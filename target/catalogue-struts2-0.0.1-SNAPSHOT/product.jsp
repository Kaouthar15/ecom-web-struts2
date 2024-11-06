<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
    <s:head />
    <meta charset="UTF-8">
    <title>Products List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
        }
        .container {
            width: 80%;
            max-width: 800px;
            margin-top: 30px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #333;
            margin-bottom: 15px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }
        table, th, td {
            border: 1px solid #ddd;
            text-align: left;
        }
        th, td {
            padding: 10px;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .action-link {
            color: #007bff;
            text-decoration: none;
        }
        .action-link:hover {
            text-decoration: underline;
        }
        .add-product-link {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 15px;
            background-color: #28a745;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
        }
        .add-product-link:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Products List: <s:property value="%{products.size}"/></h2>
        <s:if test="%{products.size > 0}">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Category</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                <s:iterator value="products"> 
                    <tr>
                        <td><s:property value="id" /></td>
                        <td><s:property value="category.name" /></td>
                        <td><s:property value="name" /></td>
                        <td><s:property value="description" /></td>
                        <td><s:property value="price" /></td>
                        <s:url var="deleteLink" action="deleteProduct">
                            <s:param name="productId"><s:property value="id" /></s:param>
                        </s:url>
                        <td><s:a href="%{deleteLink}" cssClass="action-link">Delete</s:a></td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>
        <s:else>
            <p>There are no products in the list.</p>
        </s:else>
        <a href="addProduct.jsp" class="add-product-link">Add a Product</a>
    </div>
</body>
</html>
