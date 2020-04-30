/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {config} from '../config/index';
import serviceFetch from './serviceFetch';

export default {
	/**
	 * Get an asset's value
	 * @param {object} options
	 * @param {string} options.layoutObjectReference
	 * @param {function} options.onNetworkStatus
	 */
	getCollectionField({
		collection,
		onNetworkStatus,
		segmentsExperienceId,
		size,
	}) {
		return serviceFetch(
			config.getCollectionFieldURL,
			{
				body: {
					layoutObjectReference: JSON.stringify(collection),
					segmentsExperienceId,
					size,
				},
			},
			onNetworkStatus
		);
	},

	/**
	 * Get available collection mapping fields
	 * @param {object} options
	 * @param {string} options.itemSubtype Collection itemSubtype
	 * @param {string} options.itemType Collection itemType
	 * @param {function} options.onNetworkStatus
	 */
	getCollectionMappingFields({itemSubtype, itemType, onNetworkStatus}) {
		return serviceFetch(
			config.getCollectionMappingFieldsURL,
			{
				body: {
					itemSubtype,
					itemType,
				},
			},
			onNetworkStatus
		);
	},
};
