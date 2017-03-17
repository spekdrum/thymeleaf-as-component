Intro
-----

This is a SpringBoot demo app that shows how to use Thymeleaf as a separate
component, out from MVC cycle. Allows you to use Thymeleaf template system for
other purposes like reporting, mailing, etc. It provides a service
(TlTransformService) to apply a Thymeleaf template stored in database.

 

This is based on demo from Tomasz Kaczmarzyk at
http://blog.kaczmarzyk.net/2015/01/04/loading-view-templates-from-database-with-thymeleaf

 

Use
---

mvn clean package

Run app executing Main method from
org.spekdrum.thymeleafdb.**ThymeleafDbSpringBootApplication**

 

Go to this URL for test:

http://localhost:8080/?name=Sledge

 

### How to use it in your Spring App

Take these classes:

-   SpringTemplateEngineConfig

-   TlDatabaseTemplateResolver

-   TlTransformService (not really necessary, but hides lots of public methods
    from SpringTemplateEngine).

  TlDatabaseTemplateResolver needs to be modified to use your own repository and
template entity.

 

**Applying a template**

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Context ctx = new Context();
ctx.setVariable("name", name);
String document = tlTransformService.applyTemplate("test-template", ctx);
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
