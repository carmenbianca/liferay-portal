/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import FieldType from './FieldType.es';

export default props => {
	return (
		<div className="field-type-drag-preview">
			<FieldType {...props} />
		</div>
	);
};
