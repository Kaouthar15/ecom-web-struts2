<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
    <s:head />
<%--     <sj:head /> --%>
<%--     <sb:head /> --%>
    <meta charset="UTF-8">
    <title>Categories List</title>
</head>
<body>
<!--     <div style="text-align: center"> -->
<%--         <s:textfield label="Choose a Category" id="keyword" name="keyword" onchange="javascript:show_searched();return false;" /> --%>
<!--     </div> -->
    <div>
        <h2>Categories List :  <s:property value="%{categories.size}"/></h2>
        <s:if test="%{categories.size > 0}">
            <table border="1">
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Description</td>
                    <td>Action</td>
                </tr>
                <s:iterator value="categories"> 
                    <tr>
                        <td><s:property value="id" /></td>
                        <td><s:property value="name" /></td>
                        <td><s:property value="description" /></td>
                        <s:url var="deleteLink" action="deleteCategory">
                            <s:param name="idCat"><s:property value="id" /></s:param>
                        </s:url>
                        <td><s:a href="%{deleteLink}">Delete</s:a></td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>
        <s:else>
            There are no categories in the list.
        </s:else>
        <p></p>
        <a href="addCategory.action">Add a Category</a><br /> 
    </div>
</body>
</html>
