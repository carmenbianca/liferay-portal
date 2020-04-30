/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import ClayManagementToolbar from '@clayui/management-toolbar';
import React from 'react';

export default ({addButton, setShowMobile}) => {
	return (
		<ClayManagementToolbar.ItemList>
			<ClayManagementToolbar.Item className="navbar-breakpoint-d-none">
				<ClayButton
					className="nav-link nav-link-monospaced"
					displayType="unstyled"
					onClick={() => setShowMobile(true)}
				>
					<ClayIcon symbol="search" />
				</ClayButton>
			</ClayManagementToolbar.Item>
			{addButton && (
				<ClayManagementToolbar.Item>
					{addButton()}
				</ClayManagementToolbar.Item>
			)}
		</ClayManagementToolbar.ItemList>
	);
};
