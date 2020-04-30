/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {
	useCallback,
	useContext,
	useEffect,
	useMemo,
	useReducer,
	useRef,
	useState,
} from 'react';

import useThunk from '../../core/hooks/useThunk';

const StoreContext = React.createContext(null);

/**
 * Although StoreContextProvider creates a full functional store,
 * sometimes mocking dispatchs and/or store state may be necessary
 * for testing purposes.
 *
 * This component wraps it's children with an usable StoreContext
 * that calls dispatch and getState methods instead of using a real
 * reducer internally.
 */
export const StoreAPIContextProvider = ({
	children,
	dispatch = () => {},
	getState = () => ({}),
}) => {
	const subscribers = useRef([]);

	const subscribe = useCallback(subscriber => {
		subscribers.current = [...subscribers.current, subscriber];
	}, []);

	const unsubscribe = useCallback(subscriber => {
		subscribers.current = subscribers.current.filter(
			_subscriber => _subscriber !== subscriber
		);
	}, []);

	useEffect(() => {
		storeRef.current.dispatch = dispatch;
	}, [dispatch]);

	useEffect(() => {
		storeRef.current.getState = getState;
		subscribers.current.forEach(subscriber => subscriber());
	}, [getState]);

	const storeRef = useRef({
		dispatch,
		getState,
		subscribe,
		unsubscribe,
	});

	return (
		<StoreContext.Provider value={storeRef}>
			{children}
		</StoreContext.Provider>
	);
};

/**
 * StoreContext is a black box for components: they should
 * get information from state and dispatch actions by using
 * given useSelector and useDispatch hooks.
 *
 * That's why we only provide a custom StoreContextProvider instead
 * of the raw React context.
 */
export const StoreContextProvider = ({children, initialState, reducer}) => {
	const [state, dispatch] = useThunk(useReducer(reducer, initialState));

	const getState = useCallback(() => state, [state]);

	return (
		<StoreAPIContextProvider dispatch={dispatch} getState={getState}>
			{children}
		</StoreAPIContextProvider>
	);
};

/**
 * @see https://react-redux.js.org/api/hooks#usedispatch
 */
export const useDispatch = () => {
	const storeRef = useContext(StoreContext);

	if (process.env.NODE_ENV === 'test' && !storeRef) {
		throw new Error('StoreContextProvider was not found');
	}

	return storeRef.current.dispatch;
};

/**
 * @see https://react-redux.js.org/api/hooks#useselector
 */
export const useSelector = (selector, compareEqual = (a, b) => a === b) => {
	const storeRef = useContext(StoreContext);

	if (process.env.NODE_ENV === 'test' && !storeRef) {
		throw new Error('StoreContextProvider was not found');
	}

	const initialState = useMemo(
		() => selector(storeRef.current.getState()),
		// We really want to call selector here just on component mount.
		// This provides an initial value that will be recalculated when
		// store suscription has been called.
		// eslint-disable-next-line
		[]
	);

	const [selectorState, setSelectorState] = useState(initialState);

	useEffect(() => {
		const store = storeRef.current;

		const onStoreChange = () => {
			const nextState = selector(storeRef.current.getState());

			if (!compareEqual(selectorState, nextState)) {
				setSelectorState(nextState);
			}
		};

		store.subscribe(onStoreChange);

		return () => {
			store.unsubscribe(onStoreChange);
		};
	}, [selectorState, storeRef, selector, compareEqual]);

	return selectorState;
};
