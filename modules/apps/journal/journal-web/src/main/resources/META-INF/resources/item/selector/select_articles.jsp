<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/item/selector/init.jsp" %>

<%
JournalArticleItemSelectorViewDisplayContext journalArticleItemSelectorViewDisplayContext = (JournalArticleItemSelectorViewDisplayContext)request.getAttribute(JournalWebConstants.JOURNAL_ARTICLE_ITEM_SELECTOR_VIEW_DISPLAY_CONTEXT);
%>

<clay:management-toolbar
	displayContext="<%= new JournalArticleItemSelectorViewManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, journalArticleItemSelectorViewDisplayContext) %>"
/>

<clay:container
	className="item-selector lfr-item-viewer"
	id='<%= renderResponse.getNamespace() + "articlesContainer" %>'
>
	<liferay-site-navigation:breadcrumb
		breadcrumbEntries="<%= journalArticleItemSelectorViewDisplayContext.getPortletBreadcrumbEntries() %>"
	/>

	<liferay-ui:search-container
		emptyResultsMessage="no-web-content-was-found"
		id="articles"
		searchContainer="<%= journalArticleItemSelectorViewDisplayContext.getSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="Object"
			cssClass="entry-display-style"
			modelVar="object"
		>

			<%
			JournalArticle curArticle = null;
			JournalFolder curFolder = null;

			Object result = row.getObject();

			if (result instanceof JournalFolder) {
				curFolder = (JournalFolder)result;
			}
			else {
				curArticle = journalArticleItemSelectorViewDisplayContext.getLatestArticle((JournalArticle)result);
			}
			%>

			<c:choose>
				<c:when test="<%= curArticle != null %>">

					<%
					row.setCssClass("articles " + row.getCssClass());

					JSONObject articleJSONObject = JSONUtil.put(
						"className", JournalArticle.class.getName()
					).put(
						"classNameId", PortalUtil.getClassNameId(JournalArticle.class.getName())
					).put(
						"classPK", curArticle.getResourcePrimKey()
					);

					String title = curArticle.getTitle(locale);

					if (Validator.isNull(title)) {
						title = curArticle.getTitle(LocaleUtil.fromLanguageId(curArticle.getDefaultLanguageId()));
					}

					articleJSONObject.put("title", title);

					Map<String, Object> data = HashMapBuilder.<String, Object>put(
						"value", articleJSONObject.toString()
					).build();

					row.setData(data);
					%>

					<c:choose>
						<c:when test='<%= Objects.equals(journalArticleItemSelectorViewDisplayContext.getDisplayStyle(), "descriptive") %>'>

							<%
							row.setCssClass("item-preview " + row.getCssClass());
							%>

							<liferay-ui:search-container-column-text>
								<liferay-ui:user-portrait
									userId="<%= curArticle.getUserId() %>"
								/>
							</liferay-ui:search-container-column-text>

							<liferay-ui:search-container-column-text
								colspan="<%= 2 %>"
							>

								<%
								Date createDate = curArticle.getModifiedDate();

								String modifiedDateDescription = LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - createDate.getTime(), true);
								%>

								<span class="text-default">
									<liferay-ui:message arguments="<%= new String[] {HtmlUtil.escape(curArticle.getUserName()), modifiedDateDescription} %>" key="x-modified-x-ago" />
								</span>

								<p class="font-weight-bold h5">
									<%= HtmlUtil.escape(title) %>
								</p>
							</liferay-ui:search-container-column-text>
						</c:when>
						<c:when test='<%= Objects.equals(journalArticleItemSelectorViewDisplayContext.getDisplayStyle(), "icon") %>'>

							<%
							row.setCssClass("entry-card lfr-asset-item " + row.getCssClass());
							%>

							<liferay-ui:search-container-column-text>
								<clay:vertical-card
									verticalCard="<%= new JournalArticleItemSelectorVerticalCard(curArticle, renderRequest) %>"
								/>
							</liferay-ui:search-container-column-text>
						</c:when>
						<c:otherwise>

							<%
							row.setCssClass("item-preview " + row.getCssClass());
							%>

							<c:if test="<%= journalArticleItemSelectorViewDisplayContext.showArticleId() %>">
								<liferay-ui:search-container-column-text
									name="id"
									value="<%= HtmlUtil.escape(curArticle.getArticleId()) %>"
								/>
							</c:if>

							<liferay-ui:search-container-column-text
								cssClass="table-cell-expand table-cell-minw-200 table-title"
								name="title"
								value="<%= title %>"
							/>

							<liferay-ui:search-container-column-text
								cssClass="table-cell-expand table-cell-minw-200"
								name="description"
								value="<%= StringUtil.shorten(HtmlUtil.stripHtml(curArticle.getDescription(locale)), 200) %>"
							/>

							<liferay-ui:search-container-column-text
								cssClass="table-cell-expand-smallest table-cell-minw-100"
								name="author"
								value="<%= HtmlUtil.escape(PortalUtil.getUserName(curArticle)) %>"
							/>

							<liferay-ui:search-container-column-date
								cssClass="table-cell-expand-smallest table-cell-ws-nowrap"
								name="modified-date"
								value="<%= curArticle.getModifiedDate() %>"
							/>

							<liferay-ui:search-container-column-date
								cssClass="table-cell-expand-smallest table-cell-ws-nowrap"
								name="display-date"
								value="<%= curArticle.getDisplayDate() %>"
							/>

							<%
							DDMStructure ddmStructure = curArticle.getDDMStructure();
							%>

							<liferay-ui:search-container-column-text
								cssClass="table-cell-expand-smallest table-cell-minw-100"
								name="type"
								value="<%= HtmlUtil.escape(ddmStructure.getName(locale)) %>"
							/>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:when test="<%= curFolder != null %>">

					<%
					PortletURL rowURL = journalArticleItemSelectorViewDisplayContext.getPortletURL();

					rowURL.setParameter("folderId", String.valueOf(curFolder.getFolderId()));
					%>

					<c:choose>
						<c:when test='<%= Objects.equals(journalArticleItemSelectorViewDisplayContext.getDisplayStyle(), "descriptive") %>'>
							<liferay-ui:search-container-column-icon
								icon="folder"
								toggleRowChecker="<%= true %>"
							/>

							<liferay-ui:search-container-column-text
								colspan="<%= 2 %>"
							>

								<%
								Date createDate = curFolder.getCreateDate();

								String createDateDescription = LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - createDate.getTime(), true);
								%>

								<span class="text-default">
									<liferay-ui:message arguments="<%= new String[] {HtmlUtil.escape(curFolder.getUserName()), createDateDescription} %>" key="x-modified-x-ago" />
								</span>

								<p class="font-weight-bold h5">
									<a href="<%= rowURL %>">
										<%= HtmlUtil.escape(curFolder.getName()) %>
									</a>
								</p>
							</liferay-ui:search-container-column-text>
						</c:when>
						<c:when test='<%= Objects.equals(journalArticleItemSelectorViewDisplayContext.getDisplayStyle(), "icon") %>'>

							<%
							row.setCssClass("entry-card lfr-asset-folder " + row.getCssClass());
							%>

							<liferay-ui:search-container-column-text
								colspan="<%= 2 %>"
							>
								<clay:horizontal-card
									horizontalCard="<%= new JournalFolderItemSelectorHorizontalCard(curFolder, journalArticleItemSelectorViewDisplayContext) %>"
								/>
							</liferay-ui:search-container-column-text>
						</c:when>
						<c:otherwise>
							<liferay-ui:search-container-column-text
								cssClass="table-cell-expand table-cell-minw-200 table-list-title"
								href="<%= rowURL %>"
								name="title"
								value="<%= HtmlUtil.escape(curFolder.getName()) %>"
							/>

							<liferay-ui:search-container-column-text
								cssClass="table-cell-expand table-cell-minw-200"
								name="description"
								value="<%= HtmlUtil.escape(curFolder.getDescription()) %>"
							/>

							<liferay-ui:search-container-column-text
								cssClass="table-cell-expand-smallest table-cell-minw-150"
								name="author"
								value="<%= HtmlUtil.escape(PortalUtil.getUserName(curFolder)) %>"
							/>

							<liferay-ui:search-container-column-date
								cssClass="table-cell-expand-smallest table-cell-ws-nowrap"
								name="modified-date"
								value="<%= curFolder.getModifiedDate() %>"
							/>

							<liferay-ui:search-container-column-text
								cssClass="table-cell-expand-smallest table-cell-ws-nowrap"
								name="display-date"
								value="--"
							/>

							<liferay-ui:search-container-column-text
								cssClass="table-cell-expand-smallest table-cell-minw-150"
								name="type"
								value='<%= LanguageUtil.get(request, "folder") %>'
							/>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			displayStyle="<%= journalArticleItemSelectorViewDisplayContext.getDisplayStyle() %>"
			markupView="lexicon"
			resultRowSplitter="<%= new JournalResultRowSplitter() %>"
			searchContainer="<%= searchContainer %>"
		/>
	</liferay-ui:search-container>
</clay:container>

<aui:script require="metal-dom/src/all/dom as dom">
	var selectArticleHandler = dom.delegate(
		document.querySelector('#<portlet:namespace/>articlesContainer'),
		'click',
		'.articles',
		function (event) {
			<c:choose>
				<c:when test='<%= Objects.equals(journalArticleItemSelectorViewDisplayContext.getDisplayStyle(), "icon") %>'>
					dom.removeClasses(
						document.querySelectorAll('.form-check-card.active'),
						'active'
					);
					dom.addClasses(
						dom.closest(event.delegateTarget, '.form-check-card'),
						'active'
					);
				</c:when>
				<c:otherwise>
					dom.removeClasses(
						document.querySelectorAll('.articles.active'),
						'active'
					);
					dom.addClasses(
						dom.closest(event.delegateTarget, '.articles'),
						'active'
					);
				</c:otherwise>
			</c:choose>

			Liferay.Util.getOpener().Liferay.fire(
				'<%= journalArticleItemSelectorViewDisplayContext.getItemSelectedEventName() %>',
				{
					data: {
						returnType:
							'<%= InfoItemItemSelectorReturnType.class.getName() %>',
						value: event.delegateTarget.dataset.value,
					},
				}
			);
		}
	);

	Liferay.on('destroyPortlet', function removeListener() {
		selectArticleHandler.removeListener();

		Liferay.detach('destroyPortlet', removeListener);
	});
</aui:script>