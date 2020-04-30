<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String className = GetterUtil.getString((String)request.getAttribute("liferay-ratings:ratings:className"));
long classPK = GetterUtil.getLong((String)request.getAttribute("liferay-ratings:ratings:classPK"));
Map<String, Object> data = (Map<String, Object>)request.getAttribute("liferay-ratings:ratings:data");
boolean inTrash = GetterUtil.getBoolean(request.getAttribute("liferay-ratings:ratings:inTrash"));
RatingsEntry ratingsEntry = (RatingsEntry)request.getAttribute("liferay-ratings:ratings:ratingsEntry");
RatingsStats ratingsStats = (RatingsStats)request.getAttribute("liferay-ratings:ratings:ratingsStats");
String type = GetterUtil.getString((String)request.getAttribute("liferay-ratings:ratings:type"));
%>

<liferay-util:html-top
	outputKey="com.liferay.ratings.taglib.servlet.taglib#/page.jsp"
>
	<link href="<%= PortalUtil.getStaticResourceURL(request, application.getContextPath() + "/css/main.css") %>" rel="stylesheet" type="text/css" />
</liferay-util:html-top>

<c:choose>
	<c:when test="<%= type.equals(RatingsType.LIKE.getValue()) %>">
		<div>
			<button class="btn btn-outline-borderless btn-outline-secondary btn-sm" disabled type="button">
				<svg class="lexicon-icon lexicon-icon-heart">
					<use xlink:href="<%= themeDisplay.getPathThemeImages() %>/lexicon/icons.svg#heart" />
				</svg>
			</button>

			<react:component
				data="<%= data %>"
				module="js/components/Ratings"
			/>
		</div>
	</c:when>
	<c:when test="<%= type.equals(RatingsType.THUMBS.getValue()) %>">
		<div>
			<button class="btn btn-outline-borderless btn-outline-secondary btn-sm" disabled type="button">
				<svg class="lexicon-icon lexicon-icon-thumbs-up">
					<use xlink:href="<%= themeDisplay.getPathThemeImages() %>/lexicon/icons.svg#thumbs-up" />
				</svg>
			</button>

			<button class="btn btn-outline-borderless btn-outline-secondary btn-sm" disabled type="button">
				<svg class="lexicon-icon lexicon-icon-thumbs-down">
					<use xlink:href="<%= themeDisplay.getPathThemeImages() %>/lexicon/icons.svg#thumbs-down" />
				</svg>
			</button>

			<react:component
				data="<%= data %>"
				module="js/components/Ratings"
			/>
		</div>
	</c:when>
	<c:when test="<%= type.equals(RatingsType.STARS.getValue()) %>">
		<div>
			<div class="autofit-row autofit-row-center ratings ratings-stars">
				<div class="autofit-col">
					<div class="dropdown">
						<button class="btn btn-outline-borderless btn-outline-secondary dropdown-toggle btn-sm" disabled type="button">
							<svg class="lexicon-icon lexicon-icon-star-o">
								<use xlink:href="<%= themeDisplay.getPathThemeImages() %>/lexicon/icons.svg#star-o" />
							</svg>

							<span>-</span>
						</button>
					</div>
				</div>

				<div class="autofit-col">
					<svg class="lexicon-icon lexicon-icon-star ratings-stars-average-icon">
						<use xlink:href="<%= themeDisplay.getPathThemeImages() %>/lexicon/icons.svg#star" />
					</svg>
				</div>
			</div>

			<react:component
				data="<%= data %>"
				module="js/components/Ratings"
			/>
		</div>
	</c:when>
	<c:otherwise>
		<liferay-ui:ratings
			className="<%= className %>"
			classPK="<%= classPK %>"
			inTrash="<%= inTrash %>"
			ratingsEntry="<%= ratingsEntry %>"
			ratingsStats="<%= ratingsStats %>"
			type="<%= type %>"
		/>
	</c:otherwise>
</c:choose>