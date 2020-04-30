/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/**
 * - draftSaved (0) When a request that generates a draft has finished the status will be draftSaved.
 * - error (1) When any timeout or request `error` occurs, the status will be set
 * - savingDraft (2) When a request that generates a draft is pending the status will be `savingDraft`.
 * 	 to error.
 */
export const SERVICE_NETWORK_STATUS_TYPES = {
	draftSaved: 0,
	error: 1,
	savingDraft: 2,
};
