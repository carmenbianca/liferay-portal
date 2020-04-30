/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ADD_FRAGMENT_COMPOSITION} from './types';

export default function addFragmentComposition({
	fragmentCollectionId,
	fragmentComposition,
}) {
	return {
		fragmentCollectionId,
		fragmentComposition,
		type: ADD_FRAGMENT_COMPOSITION,
	};
}
