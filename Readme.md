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

