## Spring Crash Course ##

 - It's a dependency Injection, Inversion of Control Desgin pattern framework

 - Spring framework is contains
 	Core Container
 		beans, core, context, SpEl
 	Web
 		MVC, Portlet, WebSocket, Servlet
 	Data Access/Integration
 		JDBC, ORM, JMS, Transaction
 	AOP, Aspects, Instrumentation, Messaging

 - Spring Container
 	- Spring Container is a component, which creats the object, holds the object and provide the object whenever the other object requires
 	- Container maintain the complete life cycle of object in application

 - ApplicationContext is an interface and represents the spring container implemented by 
 	- ClasspathXMLApplicationContext
 	- FileSystemXMLApplicationContext
 	- AnnotationConfigApplicationContext

 - Spring container supports two types of Dependency Injection
 	- Setter method Injection
 	- Constructor Injection

- Spring container supports two types of Dependency Injection
 	- Setter method Injection
 	- Constructor Injection

- Spring container supports two types of Data Dependency
	- Primitive Type Dependencies
		byte,short,int,long,float,double,char,boolean,string
	- Collection Types Dependencies
		Set, Map, List, Properties

- To create a simple spring core project, add the following dependecies to your pom.xml file
```xml
	<properties>
        <springframework.version>4.3.6.RELEASE</springframework.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${springframework.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${springframework.version}</version>
        </dependency>
    </dependencies>
```
- to create configuration settings (config.xml)
```xml
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
		xmlns:p="http://www.springframework.org/schema/p"
		xsi:schemaLocation="http://www.springframework.org/schema/beans
	    http://www.springframework.org/schema/beans/spring-beans.xsd
	    http://www.springframework.org/schema/context
	    http://www.springframework.org/schema/context/spring-context.xsd">
	</beans>
```

- Syntax to create a bean using setter DI
```xml
	<bean name="emp" class="package.class.name">
		<property name="id" value="20">
	</bean>
```

- Syntax to create a bean using constructor DI
```xml
	<bean name="emp" class="package.class.name">
		<constructor-arg name="id" value="20">
	</bean>
```

- three ways to pass properties to a bean
	- property value as values 
		e.g:
		```xml 
			<bean name="employee" class="com.fuppino.spring.Employee">
				<property name="id" value="10"></property>
			 	<property name="name" value="Ram"></property>
			 </bean>
		```

	- property value as element
		e.g: 
		```xml
		<bean name="employee" class="com.fuppino.spring.Employee">
				<property name="id"> 
					<value> 10 </value>
				</property>
				<property name="name">
					<value> Ram </value>
				</property>
		</bean>
		```

	- property value with p tag
		e.g: 
		```xml
		<bean name="employee3" class="com.fuppino.spring.Employee" p:id="3" p:name="name"/>
		```
	[ref](https://github.com/dvinay/Spring-crash-course/commit/ed33a66d5c60f88620e4cd2fb42208c896856124)

- Spring supports 4 types of collections as dependecies
	1) List
		default list type is arraylist
		if list contains only one element, list tag will be optional
	[ref](https://github.com/dvinay/Spring-crash-course/commit/919466965f8f26c91a6216b59e7ce4f389cf2cfc)

	2) Set
		default set type is LinkedHashSet
		if set contains only one element, set tag will be optional
	[ref](https://github.com/dvinay/Spring-crash-course/commit/016fb75683c0438462e9d8192cf4f5834b6ae723)
	
	3) Map (Key, value)
		default set type is LinkedHashMap
		if set contains only one element, set tag will be optional
	[ref](https://github.com/dvinay/Spring-crash-course/commit/c19c325a4ad5b57dbd855edbfd94d7468fdabb1e)

	4) Properties
	- e.g:
	```xml
	<bean name="employee" class="com.fuppino.spring.Employee">
		<property name="data"> 
			<props>
				<prop key="USA">English</prop>
				<prop key="INDIA">Hindi</prop>
			</props>
		</property>
	</bean>
	```
	[ref](https://github.com/dvinay/Spring-crash-course/commit/357b6eeeb2d23ac2d3da4ef1c27e653b4a0906e3)

- Spring supports has a relationship bean dependencies with ref tag
	e.g:
	```xml
	<bean name="scores" class="com.fuppino.spring.reftype.Score" p:math="90" p:chem="89" p:scie="100"/>
	<bean name="student" class="com.fuppino.spring.reftype.Student">
		<property name="name" value="Ram"/>
		<property name="score" ref="scores"/>
	</bean>
	```

- for ref beans also we can use 3 types of syntax
		
		1) ref as property value

		```xml
		<bean name="scores" class="com.fuppino.spring.reftype.Score" p:math="90" p:chem="89" p:scie="100"/>
		<bean name="student" class="com.fuppino.spring.reftype.Student">
			<property name="name" value="Ram"/>
			<property name="score" ref="scores"/>
		</bean>
		```

		2) ref as property element

		```xml
		<bean name="scores" class="com.fuppino.spring.reftype.Score" p:math="90" p:chem="89" p:scie="100"/>
		<bean name="student" class="com.fuppino.spring.reftype.Student">
			<property name="name" value="Ram"/>
			<property name="score">
				<ref bean="scores"/>
			</property>
		</bean>
		```

		3) ref value with p tag using object_name-ref

		```xml
		<bean name="scores" class="com.fuppino.spring.reftype.Score" p:math="90" p:chem="89" p:scie="100"/>
		<bean name="student" class="com.fuppino.spring.reftype.Student" p:name="Ram" p:score-ref="scores"/>
		```

### Spring bean life cycle methods ###
- Spring provides two life cycle methods for every bean it creates
	1) public void init()
	2) public void destroy()

- The flow of the life cycle is create-> set the data(setter/constructor)-> invoke init()-> read/use-> destory()-> delete

- any initialization code, like db-connection,server connection, properties setting can go into init method

- any cleanup code, like cleaning resources go into destroy
	Note: to call the destroy method. you have to call registerShutdownHook() method, which is available in AbstractApplicationContext class
	
- Three ways to configure the lifecycle method
	1) XML Configuration - init-method & destroy-method
	```xml
		<bean name="item" class="com.fuppino.spring.lc.xmlconfig.Item" p:id="23" init-method="init" destroy-method="destroy"/>
	```
	[ref](https://github.com/dvinay/Spring-crash-course/commit/ae2d8ca26467240d9e27eb99c04f251c267fafa8)

	2) implementing interfaces - InitializingBean & DisposableBean
		- POJO class must implements InitializingBean and DisposableBean
		- it needs to override afterPropertiesSet(), destroy()
		- no need to specify init-method and destroy-method attributes
		- make sure you have called registerShutdownHook() method, which is available in AbstractApplicationContext class
	[ref](https://github.com/dvinay/Spring-crash-course/commit/3d0c984fcfedb46b61a39d49a841ee312f67c63f)

	3) Annotation - @PostConstruct, @PreDestroy
		- add @PostConstruct, @PreDestroy annotations before the init and destroy methods
		
		- add CommonAnnotationBeanPostProcessor bean class to config.xml , it only supports PostConstruct and PreDestroy annotations
		```xml
		<bean
		class="org.springframework.context.annotation.CommonAnnotationBeanPostProcessor"/>
		```
		[ref](https://github.com/dvinay/Spring-crash-course/commit/9b5f5b2f4eced2025479d4e9fc4829c0a179b1b2)
		
		(or)
		- annotation-config support all the annotations
		- add 
		```xml
		<context:annotation-config/>
		```
		[ref](https://github.com/dvinay/Spring-crash-course/commit/db20a49b702fb924bfc64376599c09adb2c0569a)

### Spring dependency check ###

- spring checks the dependency, while creating a bean in container
- to check the dependency, need to add @Required before set method
- [ref](https://github.com/dvinay/Spring-crash-course/commit/738d23a86fe78c35ff3212996967a29afcb265b0)

### Spring inner bean dependency creation ###

- instead of ref tag, we can use inner bean
- inner bean will create only for the parent bean
e.g:

```xml
<bean name="employee" class="com.fuppino.spring.innerbean.Employee" p:name="Ram">
		<property name="address">
			<bean class="com.fuppino.spring.innerbean.Address" p:cityName="Fremont"/>
		</property>
</bean>
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/6470843f274fb07ccbbf5b5eaf3796f83fe1259c)

### Spring bean scope ###

- singleton => one object will create, this is default scope for bean
- prototype => each call gets new object
- request => one object per request
- session => one object per session
- global session => complete application get one object based on session

```xml
<bean name="employee" class="com.fuppino.spring.innerbean.Employee" p:name="Ram" scope="prototype">
		<property name="address">
			<bean class="com.fuppino.spring.innerbean.Address" p:cityName="Fremont"/>
		</property>
</bean>
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/2d3d4ce9707c9d1bb73144c043dc771caa8f2977)

### Spring bean creation using constructor-arg ###

- constructor-arg tag to initialize data
- spring is able to call the private constructor

```xml
<bean name="data" class="com.fuppino.spring.constructor.Data">
	<constructor-arg name="id" value="23"/>
	<constructor-arg name="name" value="Sample"/>
</bean>
```
- constructor-arg also uses as element, argument or c-schema
- for c-schema, we need to include xmlns:c="http://www.springframework.org/schema/c" into configuration file
[ref](https://github.com/dvinay/Spring-crash-course/commit/9c92ff68f5f23661d2ba2b10c19bc9f65611aec5)

### Spring bean creation using constructor-arg Ambiguity Problem ###
- As java class allows constructor overloading, there is a chance to get Ambiguity
- Spring defaultly check constructor with string data type as input. If it's not found, then it will check for first constructor.
- We can resolve this constructor-arg by using type, index or name

### Spring bean creation externalization ###
- Reading data from properties files
- to read data from properties files, we have to add context:property-placeholder in config.xml
```xml
<context:property-placeholder location="classpath:database.properties"/>
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/a0e9837c765619f05a694dbab4a54978fc1e880d)
- if the property doesn't exist then BeanDefinitionStoreException occurs


### Spring bean autowiring ###
-autowiring is a concept, where Dependency can be managed by container
-autowiring can be done, in two ways
	1) XML
		a) NO(Default)
		b) By Type (setter injection)
		c) By Name (setter injection)
		d) Auto Detect ( < spring 2.0 ) - it's outdated
		e) By Constructor (constructor injection)
	2) Annotation
		a) @Autowired
		b) @Qualifier

- autowiring using "ByType"
	- based on bean type, container will inject the bean automatically
	[ref](https://github.com/dvinay/Spring-crash-course/commit/41fec3e3cb5bb37e370360a79f2ba86076e6cbd4)
	- if your configuration xml contains multiple objects of same class type, then spring will generate the NoUniqueBeanDefinitionException.
	- if spring doesn't find the proper object type, then it inject null
	- if autowiring is depending on scope, there is chance to get different scopes depending on the scope of the main bean and auto-wired bean
```XML
<bean name="address" class="com.fuppino.spring.bytype.Address" p:cityName="Fremont"/>
    
<bean name="employee" class="com.fuppino.spring.bytype.Employee" p:name="Ram" autowire="byType"/>
```

- autowiring using "ByName"
	- based on bean name, container will inject the bean automatically
	- dependent object name must be same as the configuration
	[ref](https://github.com/dvinay/Spring-crash-course/commit/e35e7588d9ea6cb18093968c97da7fc5765e0fe9)
	- if spring doesn't find the proper object name, then it inject null
	- if autowiring is depending on scope, there is chance to get different scopes depending on the scope of the main bean and auto-wired bean

```XML
<bean name="course" class="com.fuppino.spring.byname.Course" p:subject="CSE"/>
    
<bean name="student" class="com.fuppino.spring.byname.Student" p:name="Ravana" autowire="byName"/>
```

- autowiring using "constructor"
	- based on bean type, container will inject the bean automatically
	- dependent object name must be same as the configuration
	[ref](https://github.com/dvinay/Spring-crash-course/commit/552eb183001ef971de0716ce7cb79d584d46037b)
	- if spring doesn't find the proper object type, then it inject null
	- if autowiring is depending on scope, there is chance to get different scopes depending on the scope of the main bean and auto-wired bean

```XML
<bean name="profile" class="com.fuppino.spring.autowire.byconstructor.Profile" p:skil="Java"/>
    
<bean name="job" class="com.fuppino.spring.autowire.byconstructor.Job" p:name="Software Engineer" autowire="constructor"/>
```

- autowiring using "@Autowired"
	- it's independent of config file, not need to specify the autowire tag
	- Note: add context:annotation-config to enable spring to annotations
	- based on bean type, container will inject the bean automatically
	- annotation can be placed before the setter or constructor or field level
	[ref](https://github.com/dvinay/Spring-crash-course/commit/bdb9b33dbeefddf63d70794fd0fd035e8614789c)
	- if spring doesn't find the proper object type, then it inject null
	- if autowiring is depending on scope, there is chance to get different scopes depending on the scope of the main bean and auto-wired bean
	- @Autowired has one default boolean parameter called "required"
	- @Autowired(required = true), if spring is not able to find the depe
```XML
<context:annotation-config/>

<bean name="item" class="com.fuppino.spring.autowire.annotation.Item" p:name="IPhone"/>
    
<bean name="shoppingCart" class="com.fuppino.spring.autowire.annotation.ShoppingCart"
    	p:name="onsale"/>
```

- autowiring using "@Qualifier"
	- if configuration has multiple beans with same class type; spring container is not able to fetch the exact bean while autowiring configuration
	- we can resolve this confilt or ambiguity by using @Qualifier("bean-name")
	- [ref](https://github.com/dvinay/Spring-crash-course/commit/e42ff76d57e8941dc5a355d255d45669df810b23)
	- if autowired option required is true and not matched qualifier found in the container, it will genetate NoSuchBeanDefinitionException
```XML
<bean name="model1" class="com.fuppino.spring.autowire.qualifier.Model" p:name="CR-V"/>
	
<bean name="model2" class="com.fuppino.spring.autowire.qualifier.Model" p:name="HR-V"/>
    
<bean name="car" class="com.fuppino.spring.autowire.qualifier.Car"/>
```
```JAVA
public class Car {

	@Autowired(required=false)
	@Qualifier("model2")
	private Model model;
}
```

### Spring Standalone Collections ###

- using java collections in spring is little tricky, so Spring has adapted standalone collection technique.
- to use standalone collection, add util schema and use name space and create collection
```XML
<util:CollectionName CollectionName-class="" id="">
	<value> or <entry>
</util>
```

- steps to use util
	1) add util name space xmlns:util="http://www.springframework.org/schema/util" and "http://www.springframework.org/schema/util
    http://www.springframework.org/schema/util/spring-util.xsd"
```XML
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
	xmlns:p="http://www.springframework.org/schema/p"
	xmlns:c="http://www.springframework.org/schema/c"
	xmlns:util="http://www.springframework.org/schema/util"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/util
    http://www.springframework.org/schema/util/spring-util.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">
```
	2) use utils tag to create a stand alone util
```XML
<util:list list-class="java.util.LinkedList" id="productNames">
	<value>IPhone</value>
    <value>IPad</value>
    <value>AirPod</value>
</util:list>
```
	3) give this utils object id to ref for the bean
```XML
<bean name="productList" class="com.fuppino.spring.standalone.collections.ProductList">
    <property name="productNames" ref="productNames"/>
</bean>
```

[ref](https://github.com/dvinay/Spring-crash-course/commit/fc207ee510817942417f91ecdd12c6c4adc5557d)

### Spring Sterotype Annotations ###
- Sterotype Annotation @Component
	-@Component is similar to bean tag in the configuration file
	-spring creates a bean, using new keyword
	e.g: Student student = new Student();
	- we can change the bean name by giving the name in @Component annotation like @Component("beanName")
	-we have to include following line in configuration file to spring container search the classes with @Component annotation
	- spring search the base package and sub package also for component
	- Note: annotation-config is optional part
```XML
<context:annotation-config/>
<context:component-scan base-package="com.base.package"/>
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/99c9c7b65dcc289fae2e8435b4a4bb8d93afdb4a)

- Sterotype Annotation @Scope
	- while using @Component, spring creats a bean with default scope(singleton)
	- to create bean with other scope we need to use @Scope annotation like @Scope("prototype")
[ref](https://github.com/dvinay/Spring-crash-course/commit/ba79768007cac4a8db63d69f09db8e51b784cfae)

- Sterotype Annotation @Value
	- to assign values to bean properties, we have to use @Value() annotation
	- value annotation is depending on the type of data your inserting
		- primitive data => @Value()
		[ref](https://github.com/dvinay/Spring-crash-course/commit/6db6d0e9b213dfd1c2e1499c9d93d083aac6bcae)
		- collection data => use util give util collection id in value annotation
			@Value(#{cllectionId})
		[ref](https://github.com/dvinay/Spring-crash-course/commit/75952c5cfe1a84ab13b8a753ef27ceb8f881b7b6)
		- Object type/ref => @Autowired
		[ref](https://github.com/dvinay/Spring-crash-course/commit/f0bd11c628f95ee90a3a0a45ed01583b04999c60)
	- @Value will override the value given to the property
```JAVA
	@Value(10)
	int data = 20; //the final value will be 10
```

### Spring Ecpression Language ###

- Spring expression language, supports parsing and execting the expression with help of @Value annotation using # symbol
- spring expressions are combinations of classes, methods, variable, Constructors, Objects and symblos
- you can use symbols like + symbol
@Value("#{10+30}")
[ref](https://github.com/dvinay/Spring-crash-course/commit/5c940692513c7cdaf87c923b8515ee14bb5c0fa9#diff-808b9c38dc8b43044f91790eae049152)

- you can use static methods call in spring expression language
	- @Value("#T(complete class name).method(param)")
	- @Value("#{T(java.lang.Math).abs(-99)}")
[ref](https://github.com/dvinay/Spring-crash-course/commit/79621c57e8e96865ec655c1b3a17d82f34d14528#diff-808b9c38dc8b43044f91790eae049152)

- you can use static variable in spring expression
    - @Value("#T(complete class name).variable")

- you can create an object in spring expression
	- @Value("#{new Integer()}")

- you can create a String type object in spring expression using single quote
	- @Value("#{'Ram'}")
	- @Value("#{'Ram'.toUpperCase()}")
[ref](https://github.com/dvinay/Spring-crash-course/commit/bf5a92dad08075b00acbca640be10b182578486c#diff-808b9c38dc8b43044f91790eae049152)

- you can use boolean in spring expression
	- @Value("#{34>23}")
[ref](https://github.com/dvinay/Spring-crash-course/commit/0e78b317c49368126a84bec48a8201cd8d986b9b#diff-808b9c38dc8b43044f91790eae049152)

### Spring - Interface Injection ###
- We can use runtime polymorphism by using interface object reference to child classes
- to implement, this kind of runtime polymorphism. We need to use configuration changes only, not the code changes

[ref](https://github.com/dvinay/Spring-crash-course/commit/bb31da8c68f84bc794e81894988f71a5aba73dad)
[ref](https://github.com/dvinay/Spring-crash-course/commit/35b8d48532e63bb838d171cd490ac7a32d720f5a)

- We can use same using annotation, with out touching configuration
[ref](https://github.com/dvinay/Spring-crash-course/commit/d348c67eb120e6e379f18a9d06eccec2f172ffe4#diff-5b55836b1ed7a824c0c5ee1dd1920b6b)
- If you implement multiple child classes for a single interface use @Qualifier("bean-name") and @Component("bean-name")

### Spring JDBC ###
- Spring JDBC helps to reduce the database connection and operation code by using spring template
- Spring template is compbination of JDBC technology and Template Design pattern
- Template carries all the boiler plate code for database connection
- To use JDBCTemplate in spring, we have to provide a DataSource, it is an interface javax.sql.DataSource.
- Spring provides a implementation class for DataSource called DriverManagerDataSource; we will create this bean in spring configuration
- DriverManagerDataSource takes 4 parameters, dirverClassName, url, userName, password
- JDBCTemplate provides couple of methods for sql operations
- To create a spring jdbc project, we need to add DriverManagerDataSource bean in configuration xml and pass it to JDBCTemplate bean.
```XML
<bean class="org.springframework.jdbc.datasource.DriverManagerDataSource" 
    		name="dataSource"
    		p:driverClassName="com.mysql.jdbc.Driver"
    		p:url="jdbc:mysql://localhost:8889/mydb"
    		p:username="root"
			p:password="root"/>
<bean class="org.springframework.jdbc.core.JdbcTemplate" name="jdbcTemplate" p:dataSource-ref="dataSource"/>
```
```JAVA
public class Test 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        String sql = "INSERT INTO EMPLOYEE VALUES(?,?,?)";
        int resultCount = jdbcTemplate.update(sql, new Integer(1), "Ram", "Reddy");
        System.out.println("Number of records inserted : "+resultCount);
    }
}
```
- datasource is responsible for database connection, jdbcTemplate is responsible for query execution
[ref](https://github.com/dvinay/Spring-crash-course/commit/9cd7c7ec32f0b9d685cadd5b39fc609930dad1c1)
- insert, update, delete all operations in spring jdbc are similar
- select statement has two methods, for single record and multiple records
    - queryForObject(String sql, RowMapper<T> rowmapper, Object... args) : <T>
	- query(String sql, RowMapper<T> rowmapper) : List<T>
- RowMapper is an interface in Spring jdbc, it has one method called mapRow() to assign result set to corresponding Object
[ref](https://github.com/dvinay/Spring-crash-course/commit/888758e43d49074765ffd579e93e1d0114ea43ab)

### Spring ORM ###
- ORM - Object Relational Mapping, It maps the programming object to database table and vice versa.
- J2EE standrad for doing ORM is JPA - Java Persistance API, it contains two parts
	1) API
	2) Specification
- Implementations of JPA are Hibernate, toplink, eclipselink
- Spring provides class called HibernateTemplate to support the Hibernate ORM.
- Hibernate ORM requires SessionFactory object to do SQL operations
- SessionFactory need datasource
- HibernateTemplate -> SessionFactory -> dataSource
- SessionFactory interface has implmented by LocalSessionFactoryBean. It requires basic information 
	1) dataSource
	2) hibernateProperties
		a) dialect - depending on the database type; generates sql
		b) show_sql - to display hibernate generated queries
	3) annotatedClasses
		annotations from JPA - @Entity, @Table, @Id, @Column etc
- HibernateTemplate provide basic crud method to do database operations; methods are save, update, delete, get, loadAll
- while using these methods we don't write any sql queries, hibernate generats the sql behind the scene.

- To create a spring ORM project with Hibernate ORM framework, add sping-core, context, spring-orm, hibernate-core and the db connection driver dependencies
```XML
<dependencies>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>${springframework.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${springframework.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-orm</artifactId>
			<version>${springframework.version}</version>
		</dependency>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>${hibernate.version}</version>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.6</version>
		</dependency>
</dependencies>
```
- To configure Hibernate ORM in spring configuration xml
```XML
<bean class="org.springframework.jdbc.datasource.DriverManagerDataSource"
		name="dataSource" p:driverClassName="com.mysql.jdbc.Driver" p:url="jdbc:mysql://localhost:8889/mydb"
		p:username="root" p:password="root" />

<bean class="org.springframework.orm.hibernate5.LocalSessionFactoryBean"
		name="sessionFactory" p:dataSource="dataSource">
	<property name="hibernateProperties">
		<props>
			<prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
			<prop key="hibernate.show_sql">true</prop>
		</props>
	</property>
	<property name="annotatedClasses">
		<list>
			<value>com.fuppino.spring.springorm.product.entity.Product</value>
		</list>
	</property>
</bean>

<bean class="org.springframework.orm.hibernate5.HibernateTemplate"
		name="hibernateTemplate" p:sessionFactory-ref="sessionFactory" />
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/51e2c0960ef74fa6e1c2dbd28893bb3b8acc3b93#diff-048dfe4f4f7379a37b4b993e9ef75f07)




