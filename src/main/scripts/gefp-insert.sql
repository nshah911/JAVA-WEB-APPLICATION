    insert into department (id, name)
        values (1, 'Computer Science'),
        (2, 'Electrical Engineering');
    
        
   insert into authorities
        values(1, 'Administrators'),
        (2, 'Advisors'),
        (3, 'Students');
        
        
        insert into users (id, name, password, department_id, plan_id)
        values (1, 'cysun', 'abcd', 1, 1),
        (2, 'tfox','abcd', 1, 1),
        (3, 'jdoe1','abcd', 1, 1),
        (4, 'jdoe2','abcd', 2, 2);
        
        
        
        insert into plan (id, name, department_id)
        values (1, 'Computer Science plan',1),
        (2, 'Electrical Engineering plan',2);
    
        
        
    insert into runway(id,name,plan_id)
    values (1, 'Some Runway',1),
    (2,'acedemics',1);    
        
        
    
    insert into stage(id, name, plan_id)
    values (1, 'Stage 1',1),
     (2, 'Stage 2',1);    

     
    insert into checkpoint(id, name,runway_id, stage_id)
    values (1, 'algebra',1 ,1),
    (2, 'precalclus',2 ,1);

     
    insert into users_authorities(users_id,authorities_id)
    values (1,1),
    (2,2),(3,3),(4,3); 
    
    
    insert into plan_checkpoint(plan_id,checkpoint_id)
    values (1,1),
    (1,2);
        
insert into users_checkpoint(users_id,checkpoint_id)
    values (1,1),
    (1,1); 
        
        
    