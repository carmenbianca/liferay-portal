/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.vm.amazon;

/**
 * @author Kiyoshi Lee
 */
public class AmazonVMFactory {

	public static AmazonVM getExistingAmazonVM(
		String awsAccessKeyId, String awsSecretAccessKey, String instanceId) {

		return new CentOS7AmazonVM(
			awsAccessKeyId, awsSecretAccessKey, instanceId);
	}

	public static AmazonVM newAmazonVM(
		String awsAccessKeyId, String awsSecretAccessKey, String instanceSize,
		InstanceType instanceType, String keyName) {

		if (instanceType == InstanceType.AMAZON_LINUX_2) {
			return new AmazonLinux2AmazonVM(
				awsAccessKeyId, awsSecretAccessKey, instanceSize, keyName);
		}

		if (instanceType == InstanceType.CENTOS_7) {
			return new CentOS7AmazonVM(
				awsAccessKeyId, awsSecretAccessKey, instanceSize, keyName);
		}

		throw new IllegalArgumentException("Invalid instance type");
	}

	public static enum InstanceType {

		AMAZON_LINUX_2, CENTOS_7

	}

}