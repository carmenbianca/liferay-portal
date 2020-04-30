/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayLabel from '@clayui/label';
import React from 'react';

export default ({section}) => (
	<>
		{section && (
			<ClayLabel
				className="bg-light border-0 stretched-link-layer text-uppercase"
				displayType="secondary"
				large
			>
				{section.title}
			</ClayLabel>
		)}
	</>
);
