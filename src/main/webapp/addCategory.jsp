<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <s:head />
    <meta charset="UTF-8">
    <title>Add Category</title>
</head>
<body>
    <div>
        <h2>Add New Category</h2>
        <s:form action="addCategory" method="post">
            <s:textfield label="Name" name="category.name" required="true"/>
            <s:textarea label="Description" name="category.description"/>
            <s:submit value="Add Category"/>
        </s:form>
        <p><a href="listCategories.action">Back to Category List</a></p>
    </div>
</body>
</html>