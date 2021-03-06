/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.api.interfaces.assembler;

import net.jodah.typetools.TypeResolver;
import org.modelmapper.ModelMapper;
import org.seedstack.business.api.domain.AggregateRoot;
import org.seedstack.seed.core.utils.SeedReflectionUtils;

/**
 * This assembler automatically assembles aggregates in DTO and vice versa.
 *
 * @param <A> the aggregate root
 * @param <D> the dto
 * @author pierre.thirouin@ext.mpsa.com (Pierre Thirouin)
 */
public abstract class ModelMapperAssembler<A extends AggregateRoot<?>, D> extends AbstractBaseAssembler<A, D> {

    protected Class<D> dtoClass;
    private ModelMapper assembleModelMapper;
    private ModelMapper mergeModelMapper;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public ModelMapperAssembler() {
        initModelMappers();
        Class<? extends BaseAssembler> class1 = (Class<? extends BaseAssembler>) SeedReflectionUtils.cleanProxy(getClass());
        dtoClass = (Class<D>) TypeResolver.resolveRawArguments(class1.getGenericSuperclass(), class1)[1];
    }

    public ModelMapperAssembler(Class<D> dtoClass) {
        initModelMappers();
        this.dtoClass = dtoClass;
    }

    @Override
    public D assembleDtoFromAggregate(A sourceAggregate) {
        return assembleModelMapper.map(sourceAggregate, dtoClass);
    }

    @Override
    public void assembleDtoFromAggregate(D sourceDto, A sourceAggregate) {
        assembleModelMapper.map(sourceAggregate, sourceDto);
    }

    @Override
    public void mergeAggregateWithDto(A targetAggregate, D sourceDto) {
        mergeModelMapper.map(sourceDto, targetAggregate);
    }

    void initModelMappers() {
        this.assembleModelMapper = new ModelMapper();
        configureAssembly(assembleModelMapper);

        this.mergeModelMapper = new ModelMapper();
        configureMerge(mergeModelMapper);
    }

    protected abstract void configureAssembly(ModelMapper modelMapper);

    protected abstract void configureMerge(ModelMapper modelMapper);
}
