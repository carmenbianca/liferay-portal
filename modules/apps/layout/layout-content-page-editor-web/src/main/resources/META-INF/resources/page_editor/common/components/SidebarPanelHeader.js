/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import classNames from 'classnames';
import PropTypes from 'prop-types';
import React from 'react';

export default function SidebarPanelHeader({padded = true, ...props}) {
	return (
		<h1
			{...props}
			className={classNames(
				'page-editor__sidebar__panel-header',
				'align-items-center',
				'd-flex',
				{
					[props.className]: !!props.className,
					'pt-2': padded,
					'px-3': padded,
				}
			)}
		/>
	);
}

SidebarPanelHeader.propTypes = {
	padded: PropTypes.bool,
};
