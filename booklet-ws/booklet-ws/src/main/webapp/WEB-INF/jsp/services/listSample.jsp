<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<c:forEach items="${sampleList}" var="sample">      
        ${sample.sampleName}
</c:forEach>
</body>
</html>