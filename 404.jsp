<%--
    $Id$
    $URL$
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://localmatters.com/mvc" prefix="lm" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="lmtags" %>
<%@ taglib tagdir="/WEB-INF/tags/mobile" prefix="mobile" %>
<c:import url="/WEB-INF/jsp/init.jsp" />
<lm:list action="add" list="${ cssFiles }"><lm:url value="/rs/css/mobile/404.css" /></lm:list>
<mobile:page_wrapper pageName="error">
    
        <c:import url="/WEB-INF/jsp/mobile/header.jsp">
            <c:param name="showNav" value="false" />
        </c:import>
        
        <c:choose>
            <c:when test="${ mobileLevel eq 'high' }">    
                <div class="vcardHighTier">     
                    <h3><lm:message code='404.title'/></h3>
                    <p><lm:message code='404.title.sub'/></p>
                    <p><lm:message code='404.check'/></p>
                    <p class="list"><lm:message code="404.return" />&nbsp;<a href='<c:url value="/"/>'><lm:message code='404.home'/></a> <lm:message code='404.search' /></p>
                    <ul>
                        <li>&#8211; <a href="<lm:url value='buyHome'/>"><lm:message code="result.for.sale.properties" /></a></li>
                        <li>&#8211; <a href="<lm:url value='rentHome'/>"><lm:message code="result.for.rent.properties" /></a></li>
                    	<li>&#8211; <a href="<lm:url value='agentHome'/>"><lm:message code="navigation.agent.text" /></a></li>
                    </ul>
                </div>
            </c:when>
            <c:otherwise>
                <table class="vcardLowTier" cellpadding="0" cellspacing="0">
                    <tr>
                        <td>
                            <h3><lm:message code='404.title'/></h3>
                            <p><lm:message code='404.title.sub'/></p>
                            <p><lm:message code='404.check'/></p>
                            <p class="list"><lm:message code="404.return" />&nbsp;<a href='<c:url value="/"/>'><lm:message code='404.home'/></a> <lm:message code='404.search' /></p>
                            <ul>
                                <li>&#8211; <a href="<lm:url value='buyHome'/>"><lm:message code="result.for.sale.properties" /></a></li>
                                <li>&#8211; <a href="<lm:url value='rentHome'/>"><lm:message code="result.for.rent.properties" /></a></li>
                	            <li>&#8211; <a href="<lm:url value='agentHome'/>"><lm:message code="navigation.agent.text" /></a></li>
                            </ul>
                        </td>
                    </tr>
                </table>
            </c:otherwise>
        </c:choose>
        <c:import url="/WEB-INF/jsp/mobile/footer.jsp" />
</mobile:page_wrapper>
