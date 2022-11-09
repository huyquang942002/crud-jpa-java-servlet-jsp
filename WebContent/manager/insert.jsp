<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<header>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script type="text/javascript" src="/bower_components/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/bower_components/moment/min/moment.min.js"></script>
    <script type="text/javascript" src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
    <link rel="stylesheet" href="/bower_components/bootstrap/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />
</header>
<form action="<%=request.getContextPath()%>/TaoSVServlet">
    <div class="form-row">
        <%--        <div class="col-md-4 mb-3">--%>
        <%--            <label for="validationDefault01">Ma SV</label>--%>
        <%--            <input type="text" disabled class="form-control" id="validationDefault01" name="masv" placeholder="Ma SV" value="${o.maSv}" required>--%>
        <%--            <input type="hidden" class="form-control" id="validationDefault11" name="masv" placeholder="Ma SV" value="${o.maSv}" required>--%>
        <%--        </div>--%>
        <div class="col-md-4 mb-3">
            <label for="validationDefault02">Title</label>
            <input type="text" class="form-control" id="validationDefault02" name="title" placeholder="Vớ cở ngắn xanh dương"
                   value="${o.title}" >
        </div>
        <div class="col-md-4 mb-3">
            <label for="validationDefaultUsername">Price</label>
            <div class="input-group">
                <%--                <div class="input-group-prepend">--%>
                <%--                    <span class="input-group-text" id="inputGroupPrepend2">@</span>--%>
                <%--                </div>--%>
                <input type="text" class="form-control" id="validationDefaultUsername" name="price" placeholder="560000"
                       aria-describedby="inputGroupPrepend2" value="${o.price}">
<%--                <div class="radio">--%>
<%--                    <label><input type="radio" name="optradio" value="true" checked>Nam</label>--%>
<%--                </div>--%>
<%--                <div class="radio">--%>
<%--                    <label><input type="radio" name="optradio" value="false">Nu</label>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="col-md-6 mb-3">
            <label for="validationDefault03">Size</label>
            <input type="text" class="form-control" id="validationDefault03" name="size" placeholder="XL"
                   required value="${o.size}">
        </div>
        <div class="col-md-3 mb-3">
            <label for="validationDefault04">Color</label>
            <input type="text" class="form-control" id="validationDefault04" name="color" placeholder="green"
                   required value="${o.color}">
        </div>
        <div class="col-md-3 mb-3">
            <label for="validationDefault05">Description</label>
            <input type="text" class="form-control" id="validationDefault05" name="description" placeholder="Quá tuyệt lun"
                   value="${o.description}">
        </div>
    </div>
    <label >Image</label>
    <input type="text" class="form-control" id="validationDefault45" name="image" placeholder="Ảnh xinh xẻo"
           value="${o.image}">
<%--    <input type="date" id="birthday" name="birthday">--%>
<%--    <div class="form-group">--%>
<%--        <div class="form-check">--%>
<%--            <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>--%>
<%--            <label class="form-check-label" for="invalidCheck2">--%>
<%--                Agree to terms and conditions--%>
<%--            </label>--%>
<%--        </div>--%>
<%--    </div>--%>
    <button class="btn btn-primary" type="submit">Save</button>
</form>