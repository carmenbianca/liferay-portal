/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import classNames from 'classnames';
import PropTypes from 'prop-types';
import React from 'react';

export default function SidebarPanelContent({padded = true, ...props}) {
	return (
		<div
			{...props}
			className={classNames({
				[props.className]: !!props.className,
				'px-3': padded,
			})}
		/>
	);
}

SidebarPanelContent.propTypes = {
	padded: PropTypes.bool,
};
