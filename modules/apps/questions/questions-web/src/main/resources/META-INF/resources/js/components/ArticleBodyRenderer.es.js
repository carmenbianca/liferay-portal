/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import parser from 'bbcode-to-react';
import React from 'react';

export default ({articleBody, encodingFormat}) => {
	return (
		<>
			{encodingFormat === 'bbcode' && (
				<p>{parser.toReact(articleBody)}</p>
			)}
			{encodingFormat !== 'bbcode' && (
				<p dangerouslySetInnerHTML={{__html: articleBody}} />
			)}
		</>
	);
};
