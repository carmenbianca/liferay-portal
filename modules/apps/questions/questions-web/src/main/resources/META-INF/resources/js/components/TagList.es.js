/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayLabel from '@clayui/label';
import React from 'react';
import {withRouter} from 'react-router-dom';

import Link from '../components/Link.es';

export default withRouter(({tags = [], match: {params: {sectionTitle}}}) => (
	<ul className="c-mb-0 d-flex flex-wrap list-unstyled stretched-link-layer">
		{tags.map(tag => (
			<li key={tag}>
				<ClayLabel displayType="secondary">
					<Link
						key={tag}
						to={`/questions/${
							sectionTitle ? sectionTitle + '/' : ''
						}tag/${tag}`}
					>
						{tag}
					</Link>
				</ClayLabel>
			</li>
		))}
	</ul>
));
