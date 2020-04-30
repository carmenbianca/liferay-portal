/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {getNumberOfWords} from '../utils/assets';
import {clickEvent, onReady} from '../utils/events';

const applicationId = 'WebContent';

/**
 * Returns analytics payload with WebContent information.
 * @param {Object} webContent The webContent DOM element
 * @returns {Object} The payload with webContent information
 */
function getWebContentPayload(webContent) {
	const {dataset} = webContent;

	let payload = {
		articleId: dataset.analyticsAssetId,
	};

	if (dataset.analyticsAssetTitle) {
		payload = {
			...payload,
			title: dataset.analyticsAssetTitle,
		};
	}

	return payload;
}

/**
 * Wether a WebContent is trackable or not.
 * @param {Object} element The WebContent DOM element
 * @returns {boolean} True if the element is trackable.
 */
function isTrackableWebContent(element) {
	return element && 'analyticsAssetId' in element.dataset;
}

/**
 * Sends information when user clicks on a Web Content.
 * @param {Object} The Analytics client instance
 */
function trackWebContentClicked(analytics) {
	return clickEvent({
		analytics,
		applicationId,
		eventType: 'webContentClicked',
		getPayload: getWebContentPayload,
		isTrackable: isTrackableWebContent,
		type: 'web-content',
	});
}

/**
 * Sends information when user scrolls on a WebContent.
 * @param {Object} The Analytics client instance
 */
function trackWebContentViewed(analytics) {
	const stopTrackingOnReady = onReady(() => {
		Array.prototype.slice
			.call(
				document.querySelectorAll(
					'[data-analytics-asset-type="web-content"]'
				)
			)
			.filter(element => isTrackableWebContent(element))
			.forEach(element => {
				const numberOfWords = getNumberOfWords(element);

				let payload = getWebContentPayload(element);

				payload = {
					...payload,
					numberOfWords,
				};

				analytics.send('webContentViewed', applicationId, payload);
			});
	});

	return () => stopTrackingOnReady();
}

/**
 * Plugin function that registers listeners for Web Content events
 * @param {Object} analytics The Analytics client
 */
function webContent(analytics) {
	const stopTrackingWebContentClicked = trackWebContentClicked(analytics);
	const stopTrackingWebContentViewed = trackWebContentViewed(analytics);

	return () => {
		stopTrackingWebContentClicked();
		stopTrackingWebContentViewed();
	};
}

export {webContent};
export default webContent;
