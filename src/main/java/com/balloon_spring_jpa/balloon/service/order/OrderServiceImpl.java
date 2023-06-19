package com.balloon_spring_jpa.balloon.service.order;

import com.balloon_spring_jpa.balloon.dto.OrderDTO;
import com.balloon_spring_jpa.balloon.dto.mapper.OrderMapper;
import com.balloon_spring_jpa.balloon.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    @Transactional
    @Override
    public List<OrderDTO> findAll() {
        var allEntities = repository.findAll();
        return mapper.mapToOrderDTOList(allEntities);
    }

    @Transactional
    @Override
    public OrderDTO findById(UUID id) {
        var byId = repository.findById(id).orElseThrow();
        return mapper.mapToOrderDTO(byId);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public OrderDTO save(OrderDTO order) {
        var toEntity = mapper.mapToOrderEntity(order);
        var savingEntity = repository.save(toEntity);
        return mapper.mapToOrderDTO(savingEntity);
    }

    @Transactional
    @Override
    public OrderDTO update(OrderDTO order, UUID id) {
        repository.findById(id).orElseThrow();
        var toEntity = mapper.mapToOrderEntity(order);
        toEntity.setId(id);
        var savingEntity = repository.save(toEntity);
        return mapper.mapToOrderDTO(savingEntity);
    }
}
