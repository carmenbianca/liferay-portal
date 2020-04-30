/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';
import {withRouter} from 'react-router-dom';

import Link from '../components/Link.es';
import UserPopover from './UserPopover.es';

export default withRouter(
	({
		creator,
		match: {
			params: {sectionTitle},
		},
		statistics,
	}) => (
		<Link
			className="border-0 btn btn-block btn-secondary position-relative questions-user text-left text-md-right"
			to={`/questions/${sectionTitle}/creator/${creator.id}`}
		>
			<p className="c-mb-0 small">
				{Liferay.Language.get('answered-by')}
			</p>

			<p className="c-mb-0 font-weight-bold text-dark">{creator.name}</p>

			<UserPopover creator={creator} statistics={statistics} />
		</Link>
	)
);
