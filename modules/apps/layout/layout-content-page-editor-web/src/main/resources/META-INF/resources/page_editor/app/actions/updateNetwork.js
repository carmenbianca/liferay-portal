/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {UPDATE_NETWORK} from './types';

export default function updateNetwork(network) {
	return {
		network,
		type: UPDATE_NETWORK,
	};
}
