/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {getNumberOfWords} from '../utils/assets';
import {DEBOUNCE} from '../utils/constants';
import {debounce} from '../utils/debounce';
import {clickEvent, onReady} from '../utils/events';
import {ScrollTracker} from '../utils/scroll';

const applicationId = 'Blog';

/**
 * Returns analytics payload with Blog information.
 * @param {Object} blog The blog DOM element
 * @returns {Object} The payload with blog information
 */
function getBlogPayload(blog) {
	const {dataset} = blog;

	let payload = {
		entryId: dataset.analyticsAssetId,
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
 * Wether a Blog is trackable or not.
 * @param {Object} element The Blog DOM element
 * @returns {boolean} True if the element is trackable.
 */
function isTrackableBlog(element) {
	return element && 'analyticsAssetId' in element.dataset;
}

/**
 * Sends information about Blogs scroll actions.
 * @param {Object} The Analytics client instance
 */
function trackBlogsScroll(analytics, blogElements) {
	const scrollSessionId = new Date().toISOString();
	const scrollTracker = new ScrollTracker();

	const onScroll = debounce(() => {
		blogElements.forEach(element => {
			scrollTracker.onDepthReached(depth => {
				analytics.send('blogDepthReached', applicationId, {
					...getBlogPayload(element),
					depth,
					sessionId: scrollSessionId,
				});
			}, element);
		});
	}, DEBOUNCE);

	document.addEventListener('scroll', onScroll);

	return () => {
		document.removeEventListener('scroll', onScroll);
	};
}

/**
 * Sends information when user scrolls on a Blog.
 * @param {Object} The Analytics client instance
 */
function trackBlogViewed(analytics) {
	const blogElements = [];
	const stopTrackingOnReady = onReady(() => {
		Array.prototype.slice
			.call(
				document.querySelectorAll('[data-analytics-asset-type="blog"]')
			)
			.filter(element => isTrackableBlog(element))
			.forEach(element => {
				const numberOfWords = getNumberOfWords(element);

				let payload = getBlogPayload(element);

				payload = {
					numberOfWords,
					...payload,
				};

				blogElements.push(element);

				analytics.send('blogViewed', applicationId, payload);
			});
	});
	const stopTrackingBlogsScroll = trackBlogsScroll(analytics, blogElements);

	return () => {
		stopTrackingBlogsScroll();
		stopTrackingOnReady();
	};
}

/**
 * Sends information when user clicks on a Blog.
 * @param {Object} The Analytics client instance
 */
function trackBlogClicked(analytics) {
	return clickEvent({
		analytics,
		applicationId,
		eventType: 'blogClicked',
		getPayload: getBlogPayload,
		isTrackable: isTrackableBlog,
		type: 'blog',
	});
}

/**
 * Plugin function that registers listeners for Blog events
 * @param {Object} analytics The Analytics client
 */
function blogs(analytics) {
	const stopTrackingBlogClicked = trackBlogClicked(analytics);
	const stopTrackingBlogViewed = trackBlogViewed(analytics);

	return () => {
		stopTrackingBlogClicked();
		stopTrackingBlogViewed();
	};
}

export {blogs};
export default blogs;
