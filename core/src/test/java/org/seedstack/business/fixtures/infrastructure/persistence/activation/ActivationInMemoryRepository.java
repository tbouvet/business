/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.fixtures.infrastructure.persistence.activation;

import org.seedstack.business.fixtures.InMemoryRepository;
import org.seedstack.business.fixtures.domain.activation.Activation;
import org.seedstack.business.fixtures.domain.activation.ActivationRepository;
import org.seedstack.seed.persistence.inmemory.api.Store;


@Store("ActivationInMemoryRepository")
public class ActivationInMemoryRepository extends InMemoryRepository<Activation,String> implements ActivationRepository {


}
