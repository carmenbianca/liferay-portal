<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<portlet:actionURL name="unsubscribe" var="unsubscribeURL" />

<%
MySubscriptionsManagementToolbarDisplayContext mySubscriptionsManagementToolbarDisplayContext = new MySubscriptionsManagementToolbarDisplayContext(request, liferayPortletResponse, user);

int subscriptionsCount = mySubscriptionsManagementToolbarDisplayContext.getTotalItems();
%>

<clay:management-toolbar
	actionDropdownItems="<%= mySubscriptionsManagementToolbarDisplayContext.getActionDropdownItems() %>"
	componentId="mySubscriptionsManagementToolbar"
	disabled="<%= mySubscriptionsManagementToolbarDisplayContext.isDisabled() %>"
	itemsTotal="<%= subscriptionsCount %>"
	searchContainerId="subscriptions"
	selectable="<%= mySubscriptionsManagementToolbarDisplayContext.isSelectable() %>"
	showSearch="<%= mySubscriptionsManagementToolbarDisplayContext.isShowSearch() %>"
/>

<div class="container-fluid-1280">
	<aui:form action="<%= unsubscribeURL %>" method="get" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "unsubscribe();" %>'>
		<liferay-portlet:renderURLParams varImpl="portletURL" />
		<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
		<aui:input name="subscriptionIds" type="hidden" />

		<liferay-ui:error exception="<%= NoSuchSubscriptionException.class %>" message="the-subscription-could-not-be-found" />

		<liferay-ui:error-principal />

		<aui:fieldset>
			<liferay-portlet:renderURL varImpl="iteratorURL" />

			<liferay-ui:search-container
				deltaConfigurable="<%= true %>"
				emptyResultsMessage="no-subscriptions-were-found"
				id="subscriptions"
				iteratorURL="<%= iteratorURL %>"
				rowChecker="<%= new EmptyOnClickRowChecker(renderResponse) %>"
				total="<%= subscriptionsCount %>"
			>
				<liferay-ui:search-container-results
					results="<%= SubscriptionLocalServiceUtil.getUserSubscriptions(user.getUserId(), searchContainer.getStart(), searchContainer.getEnd(), new SubscriptionClassNameIdComparator(true)) %>"
				/>

				<liferay-ui:search-container-row
					className="com.liferay.subscription.model.Subscription"
					escapedModel="<%= true %>"
					keyProperty="subscriptionId"
					modelVar="subscription"
				>

					<%
					AssetRenderer assetRenderer = MySubscriptionsUtil.getAssetRenderer(subscription.getClassName(), subscription.getClassPK());

					String rowURL = null;

					if (assetRenderer != null) {
						rowURL = assetRenderer.getURLViewInContext((LiferayPortletRequest)renderRequest, (LiferayPortletResponse)renderResponse, currentURL);
					}
					else {
						rowURL = MySubscriptionsUtil.getAssetURLViewInContext(themeDisplay, subscription.getClassName(), subscription.getClassPK());
					}
					%>

					<liferay-ui:search-container-column-text
						href="<%= rowURL %>"
						name="title"
						value="<%= MySubscriptionsUtil.getTitleText(locale, subscription.getClassName(), subscription.getClassPK(), ((assetRenderer != null) ? assetRenderer.getTitle(locale) : null)) %>"
					/>

					<liferay-ui:search-container-column-text
						href="<%= rowURL %>"
						name="asset-type"
						value="<%= ResourceActionsUtil.getModelResource(locale, subscription.getClassName()) %>"
					/>

					<liferay-ui:search-container-column-date
						href="<%= rowURL %>"
						name="create-date"
						value="<%= subscription.getCreateDate() %>"
					/>

					<liferay-ui:search-container-column-jsp
						align="right"
						cssClass="entry-action"
						path="/subscription_action.jsp"
					/>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator
					markupView="lexicon"
					resultRowSplitter="<%= new MySubscriptionsResultRowSplitter(locale) %>"
				/>
			</liferay-ui:search-container>
		</aui:fieldset>
	</aui:form>
</div>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />displayPopup',
		function(url, title) {
			Liferay.Util.Window.getWindow({
				dialog: {
					align: {
						node: null,
						points: ['tc', 'tc'],
					},
					constrain2view: true,
					cssClass: 'portlet-my-subscription',
					modal: true,
					resizable: true,
					width: 950,
				},
				title: title,
				uri: url,
			});
		},
		['liferay-util-window']
	);
</aui:script>

<aui:script sandbox="<%= true %>">
	var unsubscribe = function() {
		var form = document.getElementById('<portlet:namespace />fm');

		if (form) {
			form.setAttribute('method', 'post');

			var subscriptionIds = form.querySelector(
				'#<portlet:namespace />subscriptionIds'
			);

			if (subscriptionIds) {
				subscriptionIds.setAttribute(
					'value',
					Liferay.Util.listCheckedExcept(
						form,
						'<portlet:namespace />allRowIds'
					)
				);

				submitForm(form);
			}
		}
	};

	var ACTIONS = {
		unsubscribe: unsubscribe,
	};

	Liferay.componentReady('mySubscriptionsManagementToolbar').then(function(
		managementToolbar
	) {
		managementToolbar.on('actionItemClicked', function(event) {
			var itemData = event.data.item.data;

			if (itemData && itemData.action && ACTIONS[itemData.action]) {
				ACTIONS[itemData.action]();
			}
		});
	});
</aui:script>