/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {UPDATE_NETWORK} from '../actions/types';
import {SERVICE_NETWORK_STATUS_TYPES} from '../config/constants/serviceNetworkStatusTypes';

export const INITIAL_STATE = {
	error: null,
	lastFetch: null,
	status: SERVICE_NETWORK_STATUS_TYPES.draftSaved,
};

export default function networkReducer(networkStatus = INITIAL_STATE, action) {
	switch (action.type) {
		case UPDATE_NETWORK:
			return {
				...networkStatus,
				...action.network,
			};
		default:
			return networkStatus;
	}
}
