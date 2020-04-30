/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';
import React from 'react';

import PageContent from './PageContent';

export default function PageContents(props) {
	return (
		<ul className="list-unstyled">
			{props.pageContents.map(pageContent => (
				<PageContent key={pageContent.classPK} {...pageContent} />
			))}
		</ul>
	);
}

PageContents.propTypes = {
	pageContents: PropTypes.arrayOf(
		PropTypes.shape({
			classPK: PropTypes.string,
		})
	),
};
