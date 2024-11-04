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
    <div style="text-align: center">
        <s:textfield label="Choose a Category" id="keyword" name="keyword" onchange="javascript:show_searched();return false;" />
    </div>
    <div style="text-align: center">
        <h2>Categories List (<s:property value="%{listCategories.size}" /></h2>
        <s:if test="%{listCategories.size > 0}">
            <table border="1">
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Description</td>
                    <td>Action</td>
                </tr>
                <s:iterator value="listCategories">
                    <tr>
                        <td><s:property value="id" /></td>
                        <td><s:property value="name" /></td>
                        <td><s:property value="description" /></td>
                        <s:url var="deleteLink" action="deleteCategory">
                            <s:param name="idCat"><s:property value="id" /></s:param>
                        </s:url>
                        <td><s:a href="%{deleteLink}">Supprimer</s:a></td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>
        <s:else>
            There are no categories in the list.
        </s:else>
        <p></p>
        <a href="saisirCategorie.action">Add a Category</a><br />
    </div>
<%--     <s:combobox label="Choose a Category" name="selectedCategoryId" list="listNameCategory" headerKey="-1" headerValue="--- Please Select ---" emptyOption="true" /> --%>
<!--     <p> -->
<%--         <s:textfield label="Choice: " name="categoryChoice" /> --%>
<!--     </p> -->

<%--     <s:url var="ajaxLink" value="/searchCategories.action"> --%>
<%--         <s:param name="keyword">usb</s:param> --%>
<%--     </s:url> --%>
<%--     <sj:a id="link1" href="%{ajaxLink}" targets="ajax-results"> --%>
<!--         Send AJAX request -->
<%--     </sj:a> --%>

<!--     <div id="ajax-results"> -->
<!--         <h5>JQuery Struts Ajax result will be printed here</h5> -->
<!--     </div> -->
</body>
</html>
