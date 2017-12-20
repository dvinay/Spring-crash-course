## Spring Crash Course ##

 - Spring is a dependency Injection, Inversion of Control Desgin pattern framework

 - Spring framework is contains
 	- Core Container
 		- beans, core, context, SpEl
 	- Web
 		- MVC, Portlet, WebSocket, Servlet
 	- Data Access/Integration
 		- JDBC, ORM, JMS, Transaction
 	- AOP, Aspects, Instrumentation, Messaging

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

- Spring container supports four types of Data Dependency
	- Primitive Type Dependencies
		- byte,short,int,long,float,double,char,boolean,string
	- Collection Types Dependencies
		- Set, Map, List, Properties
	- Ref type Dependecies
	- Inner bean Dependecies

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
1) property value as values 
```XML 
<bean name="employee" class="com.fuppino.spring.Employee">
	<property name="id" value="10"></property>
	<property name="name" value="Ram"></property>
</bean>
```
2) property value as element
```XML
<bean name="employee" class="com.fuppino.spring.Employee">
	<property name="id"> 
		<value> 10 </value>
	</property>
	<property name="name">
		<value> Ram </value>
	</property>
</bean>
```
3) property value with p tag
```XML
<bean name="employee3" class="com.fuppino.spring.Employee" p:id="3" p:name="name"/>
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/ed33a66d5c60f88620e4cd2fb42208c896856124)

- Spring supports 4 types of collections as dependecies
	1) List
		- default list type is arraylist
		- if list contains only one element, list tag will be optional
	[ref](https://github.com/dvinay/Spring-crash-course/commit/919466965f8f26c91a6216b59e7ce4f389cf2cfc)
	2) Set
		- default set type is LinkedHashSet
		- if set contains only one element, set tag will be optional
	[ref](https://github.com/dvinay/Spring-crash-course/commit/016fb75683c0438462e9d8192cf4f5834b6ae723)
	3) Map (Key, value)
		- default set type is LinkedHashMap
		- if set contains only one element, set tag will be optional
	[ref](https://github.com/dvinay/Spring-crash-course/commit/c19c325a4ad5b57dbd855edbfd94d7468fdabb1e)
	4) Properties
```XML
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

- Spring supports has-a relationship bean dependencies with ref tag
```XML
<bean name="scores" class="com.fuppino.spring.reftype.Score" p:math="90" p:chem="89" p:scie="100"/>
<bean name="student" class="com.fuppino.spring.reftype.Student">
	<property name="name" value="Ram"/>
	<property name="score" ref="scores"/>
</bean>
```
- for ref beans also we can use 3 types of syntax
1) ref as property value
```XML
<bean name="scores" class="com.fuppino.spring.reftype.Score" p:math="90" p:chem="89" p:scie="100"/>
<bean name="student" class="com.fuppino.spring.reftype.Student">
	<property name="name" value="Ram"/>
	<property name="score" ref="scores"/>
</bean>
```
2) ref as property element
```XML
<bean name="scores" class="com.fuppino.spring.reftype.Score" p:math="90" p:chem="89" p:scie="100"/>
<bean name="student" class="com.fuppino.spring.reftype.Student">
	<property name="name" value="Ram"/>
	<property name="score">
		<ref bean="scores"/>
	</property>
</bean>
```
3) ref value with p tag using object_name-ref
```XML
<bean name="scores" class="com.fuppino.spring.reftype.Score" p:math="90" p:chem="89" p:scie="100"/>
<bean name="student" class="com.fuppino.spring.reftype.Student" p:name="Ram" p:score-ref="scores"/>
```

### Spring bean life cycle methods ###
- Spring provides two life cycle methods for every bean it creates
	1) public void init()
	2) public void destroy()

- The flow of the life cycle is create object-> set the data(setter/constructor)-> invoke init()-> read/use-> destory()-> delete object

- any initialization code, like db-connection,server connection, properties setting can go into init method

- any cleanup code, like cleaning resources go into destroy
	Note: to call the destroy method. you have to call registerShutdownHook() method, which is available in AbstractApplicationContext class
	
- Three ways to configure the lifecycle method
1) XML Configuration - init-method & destroy-method
```XML
<bean name="item" class="com.fuppino.spring.lc.xmlconfig.Item" p:id="23" init-method="init" destroy-method="destroy"/>
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/ae2d8ca26467240d9e27eb99c04f251c267fafa8)

2) implementing interfaces - InitializingBean & DisposableBean
	- POJO class must implements InitializingBean and DisposableBean interfaces
	- it needs to override afterPropertiesSet(), destroy()
	- no need to specify init-method and destroy-method attributes in config file
	- make sure you have called registerShutdownHook() method, which is available in AbstractApplicationContext class
[ref](https://github.com/dvinay/Spring-crash-course/commit/3d0c984fcfedb46b61a39d49a841ee312f67c63f)

3) Annotation - @PostConstruct, @PreDestroy
	- add @PostConstruct, @PreDestroy annotations before the init and destroy methods
	- add CommonAnnotationBeanPostProcessor bean class to config.xml , it only supports PostConstruct and PreDestroy annotations
[ref](https://github.com/dvinay/Spring-crash-course/commit/9b5f5b2f4eced2025479d4e9fc4829c0a179b1b2)
```XML
<bean class="org.springframework.context.annotation.CommonAnnotationBeanPostProcessor"/>
```

(or)
- annotation-config support all the annotations
[ref](https://github.com/dvinay/Spring-crash-course/commit/db20a49b702fb924bfc64376599c09adb2c0569a)
```XML
<context:annotation-config/>
```

### Spring dependency check ###

- spring checks the dependency, while creating a bean in container
- to check the dependency, need to add @Required before set method
[ref](https://github.com/dvinay/Spring-crash-course/commit/738d23a86fe78c35ff3212996967a29afcb265b0)

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

```XML
<bean name="employee" class="com.fuppino.spring.innerbean.Employee" p:name="Ram" scope="prototype">
	<property name="address">
		<bean class="com.fuppino.spring.innerbean.Address" p:cityName="Fremont"/>
	</property>
</bean>
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/2d3d4ce9707c9d1bb73144c043dc771caa8f2977)

### Spring bean creation using constructor-arg ###

- constructor-arg tag to initialize data
- spring is able to call the private constructor; it uses reflection
```XML
<bean name="data" class="com.fuppino.spring.constructor.Data">
	<constructor-arg name="id" value="23"/>
	<constructor-arg name="name" value="Sample"/>
</bean>
```
- constructor-arg also uses as element, argument as value or c-schema
- for c-schema, we need to include xmlns:c="http://www.springframework.org/schema/c" into configuration file
[ref](https://github.com/dvinay/Spring-crash-course/commit/9c92ff68f5f23661d2ba2b10c19bc9f65611aec5)

### Spring bean creation using constructor-arg Ambiguity Problem ###
- As java class allows constructor overloading, there is a chance to get Ambiguity
- Spring defaultly check constructor with string data type as input. If it's not found, then it will check for first constructor.
- We can resolve this constructor-arg by using type, index or name

### Spring bean creation externalization ###
- Reading data from properties files
- to read data from properties files, we have to add context:property-placeholder in config.xml
```XML
<context:property-placeholder location="classpath:database.properties"/>
```
```XML
<context:property-placeholder location="classpath:database.properties"/>
<bean name="extern" class="com.fuppino.spring.externalization.Extern">
 	<constructor-arg>
 		<value>${dbServer}</value>
 	</constructor-arg>
	<constructor-arg name="userId">
 		<value>${userId}</value>
 	</constructor-arg>
 	<constructor-arg name="password">
 		<value>${password}</value>
 	</constructor-arg>
</bean>
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/a0e9837c765619f05a694dbab4a54978fc1e880d)
- if the property doesn't exist then BeanDefinitionStoreException occurs


### Spring bean autowiring ###
- autowiring is a concept, where Dependency can be managed by container
- autowiring can be done, in two ways
	1) XML
		- NO(Default)
		- By Type (setter injection)
		- By Name (setter injection)
		- Auto Detect ( < spring 2.0 ) - it's outdated
		- By Constructor (constructor injection)
	2) Annotation
		- @Autowired
		- @Qualifier

- autowiring using "ByType"
	- based on bean class type, container will inject the bean automatically
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
	- we can resolve this confilt or ambiguity by using @Qualifier("bean-name")[ref](https://github.com/dvinay/Spring-crash-course/commit/e42ff76d57e8941dc5a355d255d45669df810b23)
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
- add util name space xmlns:util="http://www.springframework.org/schema/util" and "http://www.springframework.org/schema/util
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
</bean>
```
- use utils tag to create a stand alone util
```XML
<util:list list-class="java.util.LinkedList" id="productNames">
	<value>IPhone</value>
    <value>IPad</value>
    <value>AirPod</value>
</util:list>
```
- give this utils object id to ref for the bean
```XML
<bean name="productList" class="com.fuppino.spring.standalone.collections.ProductList">
    <property name="productNames" ref="productNames"/>
</bean>
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/fc207ee510817942417f91ecdd12c6c4adc5557d)

### Spring Sterotype Annotations ###
- Sterotype Annotation @Component
	- @Component is similar to bean tag in the configuration file
	- spring creates a bean, using new keyword like Student student = new Student();
	- we can change the bean name by giving the name in @Component annotation like @Component("beanName")
	- we have to include following line in configuration file to spring container search the classes with @Component annotation
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
			@Value(#{collectionId})
		[ref](https://github.com/dvinay/Spring-crash-course/commit/75952c5cfe1a84ab13b8a753ef27ceb8f881b7b6)
		- Object type/ref => @Autowired
		[ref](https://github.com/dvinay/Spring-crash-course/commit/f0bd11c628f95ee90a3a0a45ed01583b04999c60)
	- @Value will override the value given to the property
```JAVA
	@Value(10)
	int data = 20; //the final value will be 10
```

### Spring Expression Language ###

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
[ref](https://github.com/dvinay/Spring-crash-course/commit/bb31da8c68f84bc794e81894988f71a5aba73dad)
- to implement, this kind of runtime polymorphism. We need to use configuration changes only, not the code changes
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
		name="sessionFactory" p:dataSource-ref="dataSource">
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

- Transaction Managent is used to autonomous work in db operation
- Hibernate uses HibernateTransactionManager class to provide transactions, add tx:annotaion-driven in configuration and use @Transactional for the db operation
- Note: While doing any update or create operation, use @Transactional
```XML
	xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="http://www.springframework.org/schema/tx
    http://www.springframework.org/schema/tx/spring-tx.xsd"
	
	<tx:annotation-driven/>

	<bean class="org.springframework.orm.hibernate5.HibernateTransactionManager" 
		name="transactionManager" p:sessionFactory-ref="sessionFactory"/>
```
- for insert operation
[ref](https://github.com/dvinay/Spring-crash-course/commit/b8294e5eac75343178725801c75228b643ad0ce5)
- for update or delete operation
[ref](https://github.com/dvinay/Spring-crash-course/commit/922a15180fdb1c134e259363499b8035184c34c0)
-for select one record and multiple records 
[ref](https://github.com/dvinay/Spring-crash-course/commit/469114e5ec835006562c7e528b020e234a90fc32)

### Spring MVC ###
- Spring MVC is used to design dynamic web applications.
- It internally uses three desgin patterns
	a) Front Controller
	b) Handler Mapper
	c) View Resolver
- Spring MVC web application follows the followin flow
	1) client request comes
	2) Dispatcher servlet handles the request
		- it's from spring mvc framework, we use and configure it
	    - it created based on Front controller design pattern
		- we have to configure this in deployement descripter of a web application
		- It uses Handler Mapper to map the request to corresponding controller based on url
	3) Controller
		- A class can be controller by adding @Controller annotation
		- we implement method to generate model and view
	4) model and view returns to Dispatcher Servlet
	5) dispatcher servlet invokes view resolver
	6) view resolver appends prefix, view, suffix 
		- prefix - location of view files
		- view - file name
		- suffix - file extension like jsp, html, jsf
	7) dispatcher servlet display the end result
- to create spring MVC project using maven, add spring-webmvc dependecy
- Steps to create a simple dynamic web application using Spring MVC
	1) Configure the dispatcher servlet
	2) Create the spring configuration
	3) Configure the view resolver
	4) Create the Controller
	5) Create the folder structure and view

- To configure dispatcher servlet in web.xml
```XML
<servlet>
	<servlet-name>dispatcher</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
	<servlet-name>dispatcher</servlet-name>
	<url-pattern>/</url-pattern>
</servlet-mapping>
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/e660a30f36eb6d0db34fbdba7bdd49c4500a41bd#diff-69e92c6bb92c24d459319b5f291f1a13)

- to configure the spring mvc xml file and view resolver; add prefix - location for the view files and sufix - extenstion of view files
[ref](https://github.com/dvinay/Spring-crash-course/commit/c6713a74162097a2fca43aae34c5bb948a0528c8#diff-86df5f35603ce54b1e67a3ebd5df90c5)

- to create controller, @Controller and @RequestMapping("url") are the important annotations. controller at class level to inform spring to create a bean and RequestMapping to map the function to corresponding url pattern
[ref](https://github.com/dvinay/Spring-crash-course/commit/b464e6a25de56f9b2863a07b992bcae9cfe717ea)

### Spring MVC -Sending data from Controller to UI ###
- ModelAndView object act as a medium between Spring controller component and UI view.
- to send data, we need to use addObject method to add the data in the format of key and value
- modelandview.addObject('key-string','value-object');
- we can retrive the data in ui component is using request.getAttribute()
[ref](https://github.com/dvinay/Spring-crash-course/commit/1fdbe9f14e51a2100d5d84b286721af843f4bcc2)
- request url:  http://localhost:8080/springmvc/hello
- another way to retrive the data in ui component is using jsp Expression Language like ${objectname}
- Note: to enable jsp expression language add following line at top in jsp page
```XML
<%@ page isELIgnored="false" %>
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/122e9388d1178f44e17bc3581151f4a065c1642f)

- request url: http://localhost:8080/springmvc/readObject
[ref](https://github.com/dvinay/Spring-crash-course/commit/48a1985e31a1c224a9df19ffeb2c23edcc5d68ca)
- request url: http://localhost:8080/springmvc/readList
[ref](https://github.com/dvinay/Spring-crash-course/commit/877a8bc314ec430451064bf1567e8856f81a8bf2)

### Spring MVC -Sending data from UI to Controller ###
- There are two ways to send data from UI to Controller,
	- HTML Form
	- Query Parameters
- When Html form has submitted, the spring container converts and create a new model object and set the values. We have to use @ModelAttribute on our controller method parameters
- Steps to create HTML form submission
	- Create a Model object
	- Create a HTML form with field names like model fields
	- Create a controller with same URI like form in html
	- Add @ModelAttribute("model-name") as parameter in the controller post operation method
- request url: http://localhost:8080/springmvc/registrationPage
- Flow -> 
/registrationPage -> UserController, showRegistrationPage() -> display the view userreg.jsp -> form submission - Http POST method -> registerUser(@ModelAttribute("form model"))
[ref](https://github.com/dvinay/Spring-crash-course/commit/d5fc204908b4af6a2f9f2b68c7f8eb049707083a)

- When data transfer throug Query Parameters like URI?key=value&key=value..
- the key and value can be fetched in spring by using @RequestParam("key") DataType methodParam.
- spring uses request.getParamet("key") and parse the data and inject it to controller method as @RequestParam("key")
- If invalid data comes then spring throughs 400 error code
- If key is not provides by default, spring throughs 400 error code. To control this we use required=false and defaltValue parameters in @RequestParam
- The order of key doesn't matter
- request url: http://localhost:8080/springmvc/showData?id=123&name=temp&email=temp@gmail.com
[ref](https://github.com/dvinay/Spring-crash-course/commit/f61b929887b876d7684f1b364948de7978319085)
- if field is not manadatory, we can add required=fasle and defaultValue
- request url: http://localhost:8080/springmvc/showData?name=temp&email=temp
[ref](https://github.com/dvinay/Spring-crash-course/commit/352ad25dd9b242a147c50af9ae0ec262cd384af7)

- Instead of using ModelAndView object and using, we can divide data and view. ModelMap parameter and view name as string return statement.
[ref](https://github.com/dvinay/Spring-crash-course/commit/e6d7f763f244d6dfa4b5484bcabb64a94c937793)

### Spring MVC - DB Connection using ORM ###
- request url: http://localhost:8080/springmvcorm/registerUser
[ref](https://github.com/dvinay/Spring-crash-course/commit/2da26efa99bd7463297fce735a13785fd8633db4)

### Client and Server Communication ###
- Synchronous -> client will request to server and wait until get response
- ASynchronous -> client will request to server and don't wait to get response
- for AJAX Asynchronous call using JQuery
[ref](https://github.com/dvinay/Spring-crash-course/commit/93bfcd888fa4856adc160125db011049852986f3)

### Spring AOP ###
- AOP = Aspect Oriented Programming is a process of applying the external services(transaction or logging) without modifing the exisiting code or functionality.
- external services in aop is called Cross cutting concerns
- AOP terms
	- Aspect , represents external service class
	- Advice , is a method in the Aspect class
	- PointCut , expression which tells which all business method need advices
		- Pointcut doesn't tell which advice method is required by a method
	- JoinPoint , is a combination of pointcut and advice
	- Target, is a busniess class which using Aspect
	- Weaving is process of applying the advice to target using joinpoint
		- weaving is done by a special program called weaver
	- Proxy, it's a class that generate as a result of weaving process
		- it's combination of advice and business logic(target)
- Pointcut syntax:
	- Access_specifier return_type package_name.class_name.method(params);
	- we can use * - any level or .. - method parameter level
- AOP specification has been implmeneted by several frameworks like AspectJ, Spring AOP and JBoss AOP
- Spring AOP uses three ways to use AOP
	- AspectJ Annotation Driven
	- AspectJ XML Driven
	- Classic Spring Proxy-based AOP( old approach )
- AspectJ Annotation Driven
	- @Aspect - to make a class as aspect
	- we can create multiple methods as advices with following annotations
		- @Before - before a particular business method has invoked
		- @After - after a particular business method has invoked
		- @AfterReturring - applies just before return particular business method, but we can access return value inside the advice
		- @Around - both before as well as after
		- @AfterThrowing - if our business method throws exception
- to add AOP dependecies in the pom.xml
```XML
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aop</artifactId>
    <version>${springframework.version}</version>
</dependency>
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
    <version>1.6.11</version>
</dependency>
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.6.11</version>
</dependency>
```
- to configure the aop anotation, add aop nameschema and add aspect-autoproxy tag and create aspect bean in spring bean class
```XML
xmlns:aop = "http://www.springframework.org/schema/aop"
xsi:schemaLocation = http://www.springframework.org/schema/aop
    http://www.springframework.org/schema/aop/spring-aop.xsd

<aop:aspectj-autoproxy/>
```
- autoproxy scans the all the classes with @Aspect annotation
- create Aspect class object in spring bean
[ref](https://github.com/dvinay/Spring-crash-course/commit/5513054d2e28383fc1131c453e548077bb6a3fc6)

### Spring Annotation Configuration ###
- Spring 3.0 above version supports the configuration as a class and annotation instead of xml file
- Spring uses @Configure annotation to provide a class as configuration; and @Bean to create bean in configuration class file
- Use can use AnnotationConfigApplicationContext class to load configuration class; if we have multiple classes as configuration we can use register method to register multiple classes
```Java
//Bean class
@Component
public class Dao 
{
    public void create() {
    	System.out.println("created");
    }
}
//Configuration class
@Configuration
public class SpringConfig 
{
    @Bean
    public Dao dao(){
    	return new Dao();
    }
}
//Test class
public class Test 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(SpringConfig.class);
        Dao dao = config.getBean(Dao.class);
        dao.create();
    }
}
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/38150b2d3b2e6beca7f6e10574ca9060dc83fdbc)
- you can define multiple beans with @Bean annotation to create
[ref](https://github.com/dvinay/Spring-crash-course/commit/7b6f4fe1f39244f4fc4f87cbe3e208ff493ffbf9)
- If we want to split the configuration into multiplie classes, then we need to use @Import annotation in main configuration to create beans in another classes
```JAVA
// first configuration
@Configuration
public class DaoConfig 
{
    @Bean
    public Dao dao() {
    	return new Dao();
    }
}
//main configuration
@Configuration
@Import(DaoConfig.class)
public class SpringConfig 
{   
    @Bean
    public Service service(){
    	return new Service();
    }
}
//Test class
public class Test 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(SpringConfig.class);
        Dao dao = config.getBean(Dao.class);
        dao.create();
        
        Service service = config.getBean(Service.class);
        service.save();
    }
}
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/f97a681e5127fb38a995cc0b80850de26ec0828a)
- by using initmethod and destroymethod as parameters in bean class, we can create a life cycle methods of bean
    - @Bean(initMethod="init", destroyMethod="destroy")
[ref](https://github.com/dvinay/Spring-crash-course/commit/b404f59e678c53a40b2be6335951b9102fe43a1c)
- by adding scope annotation, we can specify the scope of bean in spring configuration class file
```JAVA
@Configuration
@Import(DaoConfig.class)
public class SpringConfig {
	@Bean
	@Scope("prototype")
	public Service service() {
		return new Service();
	}
}
```

### Spring Annotation Configuration for Web application ###
- Spring MVC web application uses descriptor file/web.xml to configure the descriptor servlet and descriptor servlet to configure the view resolver
- If we want to implement with out xml configuration, we have to use java file 
	- to replace web.xml, we have to create a class which extends WebApplicationInitializer from spring
	- to replace descriptor servlet, we have to create a class like SpringConfig which extends WebMvcConfigurerAdapter from spring
	- we have to mark the SpringConfig with following annotations
		- @EnableWebMvc = mvc:annotaion-driven tag
		- @ComponentScan = context:component-scan tag
		- @Configuration = beans element in spring configuration xml
- Steps to convert Spring xml based MVC application to java based configuration
	- pom.xml = update with servlet dependency and war plugin
	- replace dispatcher-servlet.xml with spring configuration class
	- replace web.xml with java class which implements WebApplicationInitializer
- Step 1:
	- update servlet dependecy and maven war plugin; make sure you have set false to failOnMissingWebXml
```XML
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
	<version>3.0.1</version>
	<scope>provided</scope>
</dependency>
<build>
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-war-plugin</artifactId>
		<version>2.4</version>
		<configuration>
			<warSourceDirectory>src/main/webapp</warSourceDirectory>
			<warName>springmvcconfig</warName>
			<failOnMissingWebXml>false</failOnMissingWebXml>
		</configuration>
	</plugin>
</build>
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/851bfdd19c8b31ed69746beb2e637b2ac98c82a0#diff-76a972cbe7e947b645857cea5f437d46)

- Step 2:
	- create SpringConfig java class, which extends WebMvcConfigurerAdapter
	- add @EnableWebMvc, @ComponentScan("location"), @Configuration annotations at class level
	- add ViewResoulver bean with @Bean annotation
```JAVA
@EnableWebMvc
@ComponentScan("com.fuppino.spring.springmvc.controller")
@Configuration
public class SpringConfig extends WebMvcConfigurerAdapter{
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	//to handle default requests
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
```
- Step 3:
	- create WebServletConfiguration java class, which implements WebApplicationInitializer
	- override onStartup() method to provide dispatcher servlet and the url
```JAVA
public class WebServletConfiguration implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(SpringConfig.class);
		
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
}
```
[ref](https://github.com/dvinay/Spring-crash-course/commit/5875479ab62c0cf7ec381d0e52b828b3f09ca459)

### Spring Boot Intro ###
- it makes easier to develop spring application
- convention over configuration
- opinionated default
- annotation based and and auto configurated
- @SpringBootApplication is super annotation which acts like configuration
- Spring-boot provides different starters to provide the spring-boot applications
- spring boot applications uses maven dependecies starts with spring-boot-starter* like spring-boot-starter,spring-boot-starter-web, spring-boot-starter-data-jpa, spring-boot-starter-data-rest
- internally spring-boot-starter uses BOM,which exist in pom file; which indicated what all dependecies should pull
- you can find the spring-boot-starter list here
[ref](https://github.com/spring-projects/spring-boot)

- How spring boot works
	- spring boot works based on programming configuration, spring boot starter pom add the dependencies and configure based on META-INF/spring.factories
	- spring.factories will decide which configuration has to enable based on condition/finds on class path
- To create spring project 
	- [ref](https://start.spring.io/)
	- create spring boot starter in eclipse or STS

- [ref](https://github.com/dvinay/Spring-crash-course/commit/dd8f3bdbccd88015947558f0c56f14c057f2d851)
- to run this project import to eclipse and run the junit test method contextLoads(), which is available in DemoApplicationTests java file

- Spring data jpa code [ref](https://github.com/dvinay/Spring-crash-course/commit/3e5d603b08936e7e860448df611e03f08783217e)

### Spring Boot Web application ###
- we need to add spring-boot-starter-web dependency
- Spring boot comes with embedded tomcat
- We no need to configuration, it will import automatically
- hit http://localhost:8080/hello?name=sample
- [ref](https://github.com/dvinay/Spring-crash-course/commit/168eebabe1740548073446132da2fdabcf5086de)

### REST ###
- Http methods are basically
	- GET - read data from server
	- POST - create data in server
	- PUT - update data resource in server (complete resource update)
	- PATCH - update data resource in server (part of resouce update)
	- DELETE - delete the resource
	- TRACE - to provide the server packet with network path
	- OPTION - provide what http operations does server can perform
- Spring MVC or Spring WEB supports the rest services creation
- to create rest services, define @RestController annotation for class and @RequestMapping("/resource_name") and operations/method with correspinding annotations like @GetMapping, @PostMapping, @PuMapping and @DeleteMapping

- Created a get operation for spring boot
- http://localhost:8080/products
[ref](https://github.com/dvinay/Spring-crash-course/commit/6b41ffaf76395f108f85dce3c7d0162887bf2c0d)
[ref](https://github.com/dvinay/Spring-crash-course/commit/55762a62ebd53689fe87e347a3c10191969e13c4)

