/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import BreadcrumbsItem from './BreadcrumbsItem';

const Breadcrumbs = ({entries}) => (
	<ol className="breadcrumb">
		{entries.map((entry, index) => (
			<BreadcrumbsItem
				active={index === entries.length - 1}
				key={entry.url}
				title={entry.title}
				url={entry.url}
			/>
		))}
	</ol>
);

export default Breadcrumbs;
