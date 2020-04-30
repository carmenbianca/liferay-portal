/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {Align, ClayDropDownWithItems} from '@clayui/drop-down';
import ClayIcon from '@clayui/icon';
import {createPortletURL} from 'frontend-js-web';
import PropTypes from 'prop-types';
import React from 'react';

const Component = ({
	checkoutURL,
	iconClass,
	iconName,
	items,
	namespace,
	selectURL,
	title,
}) => {
	const onDestroyPortlet = function() {
		Liferay.detach('destroyPortlet', onDestroyPortlet);
		Liferay.detach(namespace + 'openDialog', onSelectChangeList);
	};

	Liferay.on('destroyPortlet', onDestroyPortlet);

	const onSelectChangeList = function() {
		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true,
					width: 900,
				},
				id: namespace + 'selectChangeList',
				title: Liferay.Language.get('select-a-publication'),
				uri: selectURL,
			},
			event => {
				const portletURL = createPortletURL(checkoutURL, {
					ctCollectionId: event.ctcollectionid,
				});

				Liferay.Util.navigate(portletURL.toString());
			}
		);
	};

	Liferay.on(namespace + 'openDialog', onSelectChangeList);

	return (
		<ClayDropDownWithItems
			alignmentPosition={Align.BottomCenter}
			items={items}
			trigger={
				<button className="change-tracking-indicator-button">
					<ClayIcon className={iconClass} symbol={iconName} />

					<span className="change-tracking-indicator-title">
						{title}
					</span>

					<ClayIcon symbol="caret-bottom" />
				</button>
			}
		/>
	);
};

Component.propTypes = {
	checkoutURL: PropTypes.string,
	iconClass: PropTypes.string,
	iconName: PropTypes.string,
	namespace: PropTypes.string,
	selectURL: PropTypes.string,
	title: PropTypes.string,
};

export default function(props) {
	return <Component {...props} />;
}
