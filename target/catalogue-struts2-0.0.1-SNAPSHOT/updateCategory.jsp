<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <s:head />
    <meta charset="UTF-8">
    <title>Add Category</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 400px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label, input, textarea {
            display: block;
            width: 100%;
            font-size: 14px;
        }
        input, textarea {
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        textarea {
            resize: vertical;
        }
        .submit-button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .submit-button:hover {
            background-color: #0056b3;
        }
        .back-link {
            margin-top: 15px;
            display: inline-block;
            color: #007bff;
            text-decoration: none;
            font-size: 14px;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Add New Category</h2>
        <s:form action="updateCategory" method="post">
            <div class="form-group">
                <s:textfield label="Name" name="category.name" value="%{category.name}" />
            </div>
            <div class="form-group">
                <s:textarea label="Description" name="category.description" value="%{category.description}"/>
            </div>
             <s:hidden name="category.id" value="%{category.id}"/> 
            <s:submit cssClass="submit-button" value="Add Category"/>
        </s:form>
        <p><a class="back-link" href="listCategories.action">Back to Category List</a></p>
    </div>
</body>
</html>
