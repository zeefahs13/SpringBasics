package com.springbasics.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Value;

import com.nimbusds.jose.util.StandardCharset;

public class FileIndexer extends IAbstractLucene {

	private File fileToBeIndexed;

	@Value("${lucene.db}")
	private String luceneDataDirectory;


	private boolean create = false;

	public List<Path> filesIndexed = new ArrayList<>();

	public List<Path> getFilesIndexed() {
		return filesIndexed;
	}

	public FileIndexer(boolean create, File files) {
		this.fileToBeIndexed = files;
		this.create = create;
	}

	@Override
	public void indexFiles() {
		try {
			this.index();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void index() {
		IndexWriter writer;
		try {

			try (Directory indexDirectory = FSDirectory.open(new File(luceneDataDirectory).toPath())) {
				writer = new IndexWriter(indexDirectory, getIndexWriterConfig());
				filesIndexed.addAll(indexDocuments(writer, fileToBeIndexed));

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Path> indexDocuments(IndexWriter writer, File documentsDirectory) {
		List<Path> indexedFiles = new ArrayList<>();
		if (Files.isDirectory(documentsDirectory.toPath())) {
			try {
				@SuppressWarnings("resource")
				Stream<Path> files = Files.list(documentsDirectory.toPath());
				files.forEach(file -> {
					try {
						indexedFiles.addAll(indexDocument(writer, file,
								Files.getLastModifiedTime(file, LinkOption.NOFOLLOW_LINKS).toMillis()));
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return indexedFiles;

	}

	private List<Path> indexDocument(IndexWriter writer, Path file, long lastModifiedTime) {
		List<Path> documentsIndexed = new ArrayList<>();
		try (var stream = Files.newInputStream(file)) {
			var document = new Document();
			Field pathField = new StringField("path", file.toString(), Field.Store.YES);
			document.add(pathField);
			document.add(new LongPoint("modified", lastModifiedTime));
			document.add(new TextField("contents",
					new BufferedReader(new InputStreamReader(stream, StandardCharset.UTF_8))));

			if (writer.getConfig().getOpenMode() == OpenMode.CREATE) {
				System.out.println("Adding file " + file.toString());
				writer.addDocument(document);
				documentsIndexed.add(file);
			} else {
				System.out.println("Indexing file " + file.toString());
				writer.updateDocument(new Term("path", file.toString()), document);
				documentsIndexed.add(file);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return documentsIndexed;

	}

	private IndexWriterConfig getIndexWriterConfig() {
		Analyzer analyzer = new StandardAnalyzer();
		var config = new IndexWriterConfig(analyzer);
		if (create)
			config.setOpenMode(OpenMode.CREATE);
		if (!create)
			config.setOpenMode(OpenMode.CREATE_OR_APPEND);
		config.setUseCompoundFile(true);
		return config;
	}

}
