<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper">

<#include "../common/nav.ftl">

    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-6 column">
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <div class="form-group">
                            <label>名称</label>
                        <#--如果对象不存在，则显示为空-->
                            <input name="categoryName" type="text" class="form-control"
                                   value="${(productCategory.categoryName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>type</label>
                            <input name="categoryType" type="number" class="form-control"
                                   value="${(productCategory.categoryType)!''}"/>
                        </div>

                        <input type="hidden" name="categoryId" value="${(productCategory.categoryId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>



