/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

/**
 * The proxy combines the responsibilities of the withDispatch utilities to
 * maintain compatibility with the use of FieldBase in other fields in React
 * and isolate connection to the Metal store.
 * @param {MetalComponentInstance} object.instance
 */
export const connectStore = Component => {
	return function WithDispatch({instance, ...otherProps}) {
		const {context} = instance;

		const dispatch = (...args) =>
			(context.dispatch || instance.emit)(...args);

		const store = context.store || {};

		const emit = (name, event, value) =>
			instance.emit(name, {
				// A hacky to imitate an instance of a Metal+soy component
				fieldInstance: {
					...instance,
					...instance.props,

					// Explicitly declare the element, because it will get lost
					// in the destructuring above because the element is a getter.
					element: instance.element,
					isDisposed: instance.isDisposed,
				},
				originalEvent: event,
				value,
			});

		return (
			<Component
				{...otherProps}
				dispatch={dispatch}
				emit={emit}
				store={store}
			/>
		);
	};
};
