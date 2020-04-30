<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/personal_menu/init.jsp" %>

<%
String namespace = StringUtil.randomId() + StringPool.UNDERLINE;

long color = (long)request.getAttribute("liferay-product-navigation:personal-menu:color");
String label = (String)request.getAttribute("liferay-product-navigation:personal-menu:label");
String size = (String)request.getAttribute("liferay-product-navigation:personal-menu:size");
User user2 = (User)request.getAttribute("liferay-product-navigation:personal-menu:user");

String userStickerCssClasses = "sticker";

if (size != null) {
	userStickerCssClasses += " sticker-" + size;
}

String impersonateStickerCssClasses = "sticker";

if (size != null) {
	impersonateStickerCssClasses += " sticker-sm";
}
%>

<style type="text/css">
	.dropdown-menu-personal-menu {
		max-height: none;
	}

	.dropdown-menu-personal-menu .dropdown-item-indicator {
		padding-right: 0.5rem;
	}

	div.personal-menu-dropdown .btn {
		border-radius: 5000px;
	}

	div.personal-menu-dropdown .dropdown-item {
		color: #6B6C7E;
	}
</style>

<div class="personal-menu-dropdown" id="<%= namespace + "personal_menu_dropdown" %>">
	<c:choose>
		<c:when test="<%= Validator.isNotNull(label) %>">
			<div><%= label %></div>
		</c:when>
		<c:otherwise>
			<button aria-expanded="true" aria-haspopup="true" class="btn btn-unstyled dropdown-toggle" id="<%= namespace + "personal_menu_dropdown_toggle" %>" ref="triggerButton" type="button">
				<span class="<%= userStickerCssClasses %>">
					<liferay-ui:user-portrait
						cssClass="sticker-user-icon"
						size="<%= size %>"
						user="<%= user2 %>"
					/>

					<c:if test="<%= themeDisplay.isImpersonated() %>">
						<span class="<%= impersonateStickerCssClasses + " sticker-bottom-right sticker-circle sticker-outside sticker-user-icon" %>" id="impersonate-user-sticker">
							<span class="sticker-overlay">
								<aui:icon id="impersonate-user-icon" image="user" markupView="lexicon" />
							</span>
						</span>
					</c:if>
				</span>
			</button>
		</c:otherwise>
	</c:choose>

	<%
	ResourceURL resourceURL = PortletURLFactoryUtil.create(request, PersonalMenuPortletKeys.PERSONAL_MENU, PortletRequest.RESOURCE_PHASE);

	resourceURL.setParameter("currentURL", themeDisplay.getURLCurrent());
	resourceURL.setParameter("portletId", themeDisplay.getPpid());
	resourceURL.setResourceID("/get_personal_menu_items");

	Map<String, Object> data = HashMapBuilder.<String, Object>put(
		"color", color
	).put(
		"isImpersonated", themeDisplay.isImpersonated()
	).put(
		"itemsURL", resourceURL.toString()
	).put(
		"label", label
	).put(
		"size", size
	).build();

	if (user2.getPortraitId() > 0) {
		data.put("userPortraitURL", user2.getPortraitURL(themeDisplay));
	}
	%>

	<react:component
		data="<%= data %>"
		module="personal_menu/js/PersonalMenu.es"
	/>
</div>