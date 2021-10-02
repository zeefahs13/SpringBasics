package com.springbasics.model;

public class HibernateNotes {
	
	
	
	/************************************** Notes **********************************
	 * 
	 * @ValueTypesAndEmbeddingObjects:
	 * 
	 * 1. Entity[ Ex: Customer.java]
	 * 2. Value Object
	 * 
	 * ValueObject: 
	 * 			Its an object having data that needs to be stored to database. Its not an object and it provides meaning to someother
	 * objects. For example User has address and address is the value object of User object
	 * 
	 * You can have an entity inside an entity. Value object itself has no meaning it has to be associated with some othe entity
	 * 
	 * Ex: User class can have @Embedded Object and Address is having @Embeddable on the class which means that adress is a value object and
	 * @Embedded is the object which is embedded inside User class
	 * 
	 * 
	 * 
	 * @AttributeOverride:
	 * 
	 * This will override the column names of Embedded fields inorder to differentiate between 2 sets of values for exmaple home_address and office_address
	 * 
	 * We need to follow below rules to override the embeddable field names inside database
	 * 
	 * @Embedded
	 * @AttributeOverrides({
	 * 
	 * @AttributeOverride(name ="street",column=@Column(name="home_street")),
	 * @AttributeOverride(name="pincode",column=@Column(name="home_pincode"))
	 * })
	 * 
	 * 
	 * 
	 * @EmbeddedId: If we want to use the primary key based on the embedded object, we can use this annotation.
	 * We cannot use this annotation along with @Id annotation
	 * 
	 * 
	 * 
	 * 
	 * @SAVINGCOLLECTIONOBJECTS
	 * ------------------------
	 * 
	 * Set: 
	 * 
	 * @ElementCollection
	 * private Set<Address> listOfAddresses = new HashSet<>();
	 * 
	 * Autogenerates table name like User_listOfAddresses and adds values into the db with primary key as User_userId(Object_primary key of object class in which its declared)
	 * 
	 * 
	 * 
	 * 
	 * @CONFIGURINGCOLLECTIONS AND @ADDINGKEYS:
	 * ---------------------------------------
	 * 
	 * @ElementCollection
	 * @JoinTable(name="user_address",
	 * joinColumns=@JoinColumn(name="user_address_id")
	 * )
	 * private Set<Address> listOfAddresses = new HashSet<>();
	 * 
	 * 
	 * @CONFIGURINGPRIMARYKEYS:
	 * ------------------------
	 * 
	 * 
	 * Except @CollectionId every annotation mentioned here is in compliance with JPA, where @CollectionId will
	 * change based on impl and this holds good only for hibenate
	 * 
	 * 
	 * @GenericGenerator is also from hibernate
	 * 
	 * @ElementCollection
	 * @GenericGenerator(name="hilo.gen",strategy="hilo")
	 * @JoinTable(name="user_address",
	 * joinColumns=@JoinColumn(name="user_address_id")
	 * )
	 * @CollectionId(columns={@Column(name="address_id")},generator="hilo.gen",type=@Type(type="long"))
	 * private Collection<Address> listOfAddresses = new ArrayList<>();
	 * 
	 * 
	 * 
	 * 
	 * ################ VERY IMPORTANT ###########################
	 * 
	 * @PROXYOBJECTS AND @EAGER&LAZY FETCH TYPES:
	 * ------------------------------------------
	 * 
	 * Lazy loading:
	 * -------------
	 * 
	 * Hibernate by default loads the data lazily Initialization and doesnt initialize all objects at once
	 * 
	 * Hibernate will load the internal object when the getter of that object is called by using proxy object
	 * (refer proxy design pattern once). It will generate a proxy object and then loads only basic objects and when internal objects
	 * are called it makes a query to the db and gets the internal object
	 * 
	 * Eager Loading:
	 * --------------
	 * 
	 * Hibernate fetches all the objects at once and takes some time to get the date.
	 * Find the configuration below for fetching objects eagerly
	 * 
	 * @ElementCollection(fetch=FetchType.EAGER)
	 * @GenericGenerator(name="hilo.gen",strategy="hilo")
	 * @JoinTable(name="user_address",
	 * joinColumns=@JoinColumn(name="user_address_id")
	 * )
	 * @CollectionId(columns={@Column(name="address_id")},generator="hilo.gen",type=@Type(type="long"))
	 * private Collection<Address> listOfAddresses = new ArrayList<>();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
	
	

}
