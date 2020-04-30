/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import classNames from 'classnames';
import React from 'react';

const BreadcrumbsItem = ({active, title, url}) => (
	<li
		className={classNames('breadcrumb-item', {
			active,
		})}
	>
		{active ? (
			<span className="breadcrumb-text-truncate">{title}</span>
		) : (
			<a className="breadcrumb-link" href={url}>
				<span className="breadcrumb-text-truncate">{title}</span>
			</a>
		)}
	</li>
);

export default BreadcrumbsItem;
