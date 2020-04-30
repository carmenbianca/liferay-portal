/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import middlewares from './middlewares/defaults';

/**
 * Client used to abstract communication with the Analytics Endpoint. It exposes the send
 * and use methods as only valid entry points for sending and modifying requests.
 */
class Client {
	/**
	 * Returns a Request object with all data from the analytics instance
	 * including the batched event objects
	 * @param {Object} analytics The Analytics instance from which the data is extracted
	 * @param {string} userId The userId string representation
	 * @protected
	 * @returns {Object} Parameters of the request to be sent.
	 */
	_getRequestParameters() {
		const headers = new Headers();

		headers.append('Content-Type', 'application/json');

		return {
			cache: 'default',
			credentials: 'same-origin',
			headers,
			method: 'POST',
			mode: 'cors',
		};
	}

	/**
	 * Returns the Response object or a rejected Promise based on the
	 * HTTP Response Code of the Response object
	 * @param {Object} response Response
	 * @returns {Object} Promise
	 */
	_validateResponse(response) {
		if (!response.ok) {
			response = new Promise((_, reject) => reject(response));
		}

		return response;
	}

	/**
	 * Returns a resolved or rejected promise as per the response status or if the request times out.
	 * @param {Object} analytics The Analytics instance from which the data is extracted
	 * @param {string} userId The userId string representation
	 * @returns {Object} Promise object representing the result of the operation
	 */
	sendWithTimeout({payload, timeout, url}) {
		return Promise.race([
			this.send({payload, url}),
			this._timeout(timeout),
		]);
	}

	/**
	 * Send a request with given payload and url.
	 */
	send({payload, url}) {
		return fetch(url, {
			...this._getRequestParameters(),
			body: JSON.stringify(payload),
		}).then(this._validateResponse);
	}

	/**
	 * Returns a promise that times out after the given time limit is exceeded
	 * @param {number} timeout
	 * @returns {Object} Promise
	 */
	_timeout(timeout) {
		return new Promise((_, reject) => setTimeout(reject, timeout));
	}

	/**
	 * Adds a middleware function to provide ability to transform the request
	 * that is sent to the endpoint
	 * @param {Function} middleware A function to alter request
	 * @example
	 * Client.use(
	 *   (req, analytics) => {
	 *     req.firstEvent = analytics.events[0];
	 *     req.myMetaInfo = 'myMetaInfo';
	 *
	 *     return req;
	 *   }
	 * );
	 */
	use(middleware) {
		middlewares.push(middleware);
	}
}

export {Client};
export default Client;
