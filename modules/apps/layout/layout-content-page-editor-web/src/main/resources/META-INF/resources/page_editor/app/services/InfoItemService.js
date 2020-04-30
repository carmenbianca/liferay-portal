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
	 * @param {string} options.classNameId Asset's className
	 * @param {string} options.classPK Asset's classPK
	 * @param {string} options.fieldId
	 * @param {string} [options.languageId]
	 * @param {function} options.onNetworkStatus
	 */
	getAssetFieldValue({
		classNameId,
		classPK,
		fieldId,
		languageId,
		onNetworkStatus,
	}) {
		return serviceFetch(
			config.getAssetFieldValueURL,
			{
				body: {
					classNameId,
					classPK,
					fieldId,
					languageId,
				},
			},
			onNetworkStatus
		);
	},

	/**
	 * Get available asset mapping fields
	 * @param {object} options
	 * @param {string} options.classNameId Asset's className
	 * @param {string} options.classPK Asset's classPK
	 * @param {function} options.onNetworkStatus
	 */
	getAvailableAssetMappingFields({classNameId, classPK, onNetworkStatus}) {
		return serviceFetch(
			config.getAssetMappingFieldsURL,
			{
				body: {
					classNameId,
					classPK,
				},
			},
			onNetworkStatus
		);
	},

	/**
	 * Get available structure mapping fields
	 * @param {object} options
	 * @param {string} options.classNameId Asset's className
	 * @param {string} options.classTypeId Asset's classTypeId
	 * @param {function} options.onNetworkStatus
	 */
	getAvailableStructureMappingFields({
		classNameId,
		classTypeId,
		onNetworkStatus,
	}) {
		return serviceFetch(
			config.mappingFieldsURL,
			{
				body: {
					classNameId,
					classTypeId,
				},
			},
			onNetworkStatus
		);
	},

	/**
	 * Get available templates for an asset
	 * @param {object} options
	 * @param {string} options.className Asset's className
	 * @param {string} options.classPK Asset's classPK
	 * @param {function} options.onNetworkStatus
	 */
	getAvailableTemplates({className, classPK, onNetworkStatus}) {
		return serviceFetch(
			config.getAvailableTemplatesURL,
			{
				body: {
					className,
					classPK,
				},
			},
			onNetworkStatus
		);
	},

	/**
	 * Get page contents
	 * @param {object} options
	 * @param {function} options.onNetworkStatus
	 */
	getPageContents({onNetworkStatus}) {
		return serviceFetch(config.getPageContentsURL, {}, onNetworkStatus);
	},
};
