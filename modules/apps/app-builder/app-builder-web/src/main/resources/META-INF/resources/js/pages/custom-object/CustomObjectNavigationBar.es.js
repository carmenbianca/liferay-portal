/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayNavigationBar from '@clayui/navigation-bar';
import React from 'react';
import {NavLink, withRouter} from 'react-router-dom';

const {Item} = ClayNavigationBar;

export default withRouter(({match: {url}}) => {
	const blur = event => {
		event.target.blur();
	};

	return (
		<ClayNavigationBar
			inverted
			triggerLabel={Liferay.Language.get('form-views')}
		>
			<Item key="0">
				<NavLink
					activeClassName="active"
					className="nav-link"
					onClick={blur}
					to={`${url}/form-views`}
				>
					{Liferay.Language.get('form-views')}
				</NavLink>
			</Item>

			<Item key="1">
				<NavLink
					activeClassName="active"
					className="nav-link"
					onClick={blur}
					to={`${url}/table-views`}
				>
					{Liferay.Language.get('table-views')}
				</NavLink>
			</Item>

			<Item key="2">
				<NavLink
					activeClassName="active"
					className="nav-link"
					onClick={blur}
					to={`${url}/apps`}
				>
					{Liferay.Language.get('apps')}
				</NavLink>
			</Item>
		</ClayNavigationBar>
	);
});
