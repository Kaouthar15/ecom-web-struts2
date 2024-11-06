<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <s:head />
    <meta charset="UTF-8">
    <title>Add Product</title>
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
        <h2>Add New Product</h2>
        <s:form action="addProduct" method="post">
            <div class="form-group">
                <s:textfield label="Product Name" name="product.name" required="true"/>
            </div>
               <div class="form-group">
                <s:textarea label="SDR" name="product.sdr"/>
            </div>
            <div class="form-group">
                <s:textarea label="Quantity" name="product.quantity"/>
            </div>
            <div class="form-group">
                <s:textfield label="Price" name="product.price" required="true" />
            </div>
			 <div class="form-group">
			  	<s:select id="category" name="categoryId" list="categories" listKey="id" listValue="name" required="true"/>
			  </div>
            <s:submit cssClass="submit-button" value="Add Product"/>
        </s:form>
        <p><a class="back-link" href="listProducts.action">Back to Product List</a></p>
    </div>
</body>
</html>
