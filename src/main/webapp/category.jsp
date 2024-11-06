<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
    <s:head />
    <meta charset="UTF-8">
    <title>Categories List</title>
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
        .add-category-link {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 15px;
            background-color: #28a745;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
        }
        .add-category-link:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
	<a href=""></a>
    <div class="container">
            <a class="add-category-link" href="listProducts.action"> Product List</a>
        <h2>Categories List: <s:property value="%{categories.size}"/></h2>
        <s:if test="%{categories.size > 0}">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Action</th>
                </tr>
                <s:iterator value="categories"> 
                    <tr>
                        <td><s:property value="id" /></td>
                        <td><s:property value="name" /></td>
                        <td><s:property value="description" /></td>
                        <s:url var="deleteLink" action="deleteCategory">
                            <s:param name="categoryId"><s:property value="id" /></s:param>
                        </s:url>
                        <td><s:a href="%{deleteLink}" cssClass="action-link">Delete</s:a></td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>
        <s:else>
            <p>There are no categories in the list.</p>
        </s:else>
        <a href="addCategory.jsp" class="add-category-link">Add a Category</a>

    </div>
</body>
</html>
