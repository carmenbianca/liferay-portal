/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const ENDPOINT_URL = 'https://ac-server.io';

export const INITIAL_ANALYTICS_CONFIG = {
	channelId: '4321',
	dataSourceId: '1234',
	endpointUrl: ENDPOINT_URL,
};

/**
 * Flush the current Promise queue.
 */
export const flushPromises = () =>
	new Promise(resolve => setImmediate(resolve));

/**
 * Sends dummy events to test the Analytics API
 *
 * @param {Analytics} analyticsInstance - Analytics instance.
 * @param {number} eventsNumber - Number of events to send.
 */
export const sendDummyEvents = (analyticsInstance, eventsNumber) => {
	const events = getDummyEvents(eventsNumber);

	events.forEach(event => {
		analyticsInstance.send(
			event.eventId,
			event.applicationId,
			event.properties
		);
	});
};

/**
 * Generate a single dummy event.
 *
 * @param {Number} [eventId] - Event id.
 * @param {object} [data] - Object to override event data.
 */
export const getDummyEvent = (eventId = 0, data = {}) => {
	return {
		applicationId: 'test',
		eventId,
		properties: {
			a: 1,
			b: 2,
			c: 3,
		},
		...data,
	};
};

/**
 * Generate dummy events.
 *
 * @param {number} eventsNumber - Number of events to generate.
 */
export const getDummyEvents = (eventsNumber = 5) => {
	const events = [];

	for (let i = 0; i < eventsNumber; i++) {
		events.push(getDummyEvent(i));
	}

	return events;
};

/**
 * Wait during a test. Cannot use with jest.useFakeTimers()
 *
 * @param {Number} msToWait
 */
export const wait = msToWait => {
	return new Promise(resolve => {
		setTimeout(resolve, msToWait);
	});
};
