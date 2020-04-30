/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayIcon from '@clayui/icon';
import React from 'react';

export default ({className, symbol, value}) => {
	return (
		<div
			className={`c-py-2 c-px-3 rounded stretched-link-layer ${className}`}
		>
			<ClayIcon symbol={symbol} />

			<span className="c-ml-2 font-weight-bold small">{value || 0}</span>
		</div>
	);
};
