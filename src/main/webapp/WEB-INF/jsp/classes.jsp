<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
<div id="contentwrapper">
<div class="main_content">
<div class="row-fluid">
<div class="span12">

			 <div class="btn-group sepH_b">
                                <button data-toggle="dropdown" class="btn dropdown-toggle">Action <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><a href="classes/c" class="delete_rows_simple" data-tableid="smpl_tbl"><i class="icon-adt_atach"></i>Create</a></li>
                                </ul>
             </div>
		
            <table class="table table-striped table-bordered table-condensed">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                
                <c:forEach items="${apexClass}" var="apexClass">
                   <tr>
                       <td>
                       	<a href="apex/${apexClass['Id']}">
                       		${apexClass['Name']}
                       	</a>
                       </td>
                       <td>
                       	<a href="#" onClick="SFDC.deleteApexClass( '${apexClass.metadata.name}', 
                       											   '${apexClass['Id']}', 
                       											   '${apexClass['Name']}')"
                       		class="btn btn-danger btn-mini">Delete</a>
                       </td>
                   </tr>
               </c:forEach>
               
               </tbody>
           </table>
        </div>
    </div>
  </div>
</div>
    <script type="text/javascript">
    var SFDC = {
    		deleteApexClass: function(type, id, name) {
            if (!confirm("Are you sure you want to delete '" +  name + "'?")) {
                return false;
            }

            $.ajax({
                'url': 'classes/'+id,
                'type': 'DELETE',
                'success': function(data, textStatus, jqXHR) {
                    location.href = '/sfdc/classes'
                },
                'error': function(jqXHR, textStatus, errorThrown) {
                    alert('Failed to delete class.');
                }
            })
        }
    };
	</script>
<jsp:include page="footer.jsp"/>